package HospitalReservas.Hospital_Reservas.Config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import HospitalReservas.Hospital_Reservas.Modal.Usuarios;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Service
public class JwtTokenProvider {

    private static final String SECRET_KEY = "PRdukwOSJ3ZUfLUWyJgMT0WPM58mbidmGzTs7twyuIFOsRkzfqMOBEnwGh3H7dF2xjYIsLCC//kNovCJWgQikg==";

   
    public String generateToken(UserDetails userDetails) {
    Map<String, Object> claims = new HashMap<>();

    if (userDetails instanceof Usuarios usuario) {
        // Agregar nombre de usuario
        claims.put("nombreUsuario", usuario.getUsername());

        // Agregar roles separados por coma
        String roles = usuario.getRoles().stream()
                .map(r -> r.getNombre().name())
                .collect(Collectors.joining(","));

        if (roles.isEmpty()) {
            roles = "ROLE_USER";
        }

        claims.put("roles", roles);
    }

    return buildToken(claims, userDetails);
}

    
    private String buildToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 horas
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    
    public String getUsernameFromJWT(String token) {
        return extractAllClaims(token).getSubject();
    }

    
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
