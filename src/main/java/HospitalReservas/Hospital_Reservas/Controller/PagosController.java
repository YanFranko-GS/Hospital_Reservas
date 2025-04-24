package HospitalReservas.Hospital_Reservas.Controller;

import HospitalReservas.Hospital_Reservas.Modal.Pagos;
import HospitalReservas.Hospital_Reservas.Service.PagosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private PagosService pagosService;

    @GetMapping
    public ResponseEntity<List<Pagos>> listarPagos() {
        return ResponseEntity.ok(pagosService.listarPagos());
    }

    @GetMapping("/{id_pago}")
    public ResponseEntity<Pagos> obtenerPagoPorId(@PathVariable("id_pago") Long idPago) {
        Optional<Pagos> pago = pagosService.findByIdPago(idPago);
        return pago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pagos> crearPago(@RequestBody Pagos pagos) {
        Pagos nuevoPago = pagosService.savePago(pagos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPago);
    }

    @PutMapping("/{id_pago}")
    public ResponseEntity<Pagos> actualizarPago(@PathVariable Long id_pago, @RequestBody Pagos pagoActualizado) {
        Optional<Pagos> pago = pagosService.actualizarPago(id_pago, pagoActualizado);
        return pago.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id_pago}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id_pago) {
        if (pagosService.deletePago(id_pago)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}