package terceraEntregaTpi.M;
import java.time.LocalDate;

public class Recarga {
    private static int contador = 1;
    private int id;
    private LocalDate fecha = LocalDate.now();
    private Double monto;
    private Double saldoActual;
    private Double saldoAnterior;

    public Recarga(Double m, Double sa) {
        this.id = contador++;
        this.monto = m;
        this.saldoActual = sa;
        this.saldoAnterior = this.saldoActual - this.monto;
    }

    public String toString() {
        return("--- Recarga " + id + " ---\n" + "Fecha: " + fecha + "\nMonto recargado: " + monto + "\nSaldo anterior: " + saldoAnterior + "\nSaldo actual: " + saldoActual);
    }
}
