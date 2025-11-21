package terceraEntregaTpi.V;
import javax.swing.text.*;

public class FiltroNumericoRecargaDeSaldo extends DocumentFilter {

    
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr)
            throws BadLocationException {
        
        if (text != null && text.matches("\\d+")) {
            super.insertString(fb, offset, text, attr);
        }
        
    }

    
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException{
        if (text == null) {
            super.replace(fb, offset, length, "", attr);
            return;
        }
        if (text.matches("\\d+")) {super.replace(fb, offset, length, text, attr);}
    }

    
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        super.remove(fb, offset, length); 
    }
}
