package terceraEntregaTpi.V;
import javax.swing.text.*;

public class FiltroNumericoRecargaDeSaldo extends DocumentFilter {

    public void insertString(FilterBypass filtro, int posicion, String texto, AttributeSet atributo) throws BadLocationException {
        if (texto != null && texto.matches("\\d+")) {super.insertString(filtro, posicion, texto, atributo);}
    }

    public void replace(FilterBypass filtro, int posicion, int longitud, String texto, AttributeSet atributo) throws BadLocationException{
        if (texto == null) {
            super.replace(filtro, posicion, longitud, "", atributo);
            return;
        }
        if (texto.matches("\\d+")) {super.replace(filtro, posicion, longitud, texto, atributo);}
    }

    public void remove(FilterBypass filtro, int posicion, int longitud) throws BadLocationException {
        super.remove(filtro, posicion, longitud);
    }
}
