package Conversor;
import javax.swing.JOptionPane;

public class Conversor {
    public static void main(String[] args) throws Exception {

        String[] OptionsConversor = { "Conversor de Moeda", "Conversor de Temperatura" };
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        ConversorTemperatura ConversorTemperatura = new ConversorTemperatura();
        int continuar = 0;
        String optionConversor = "";
        do {
            try {
                optionConversor = JOptionPane.showInputDialog(null, "Escolha um conversor: ", "Menu",
                        JOptionPane.PLAIN_MESSAGE, null, OptionsConversor, JOptionPane.MESSAGE_TYPE_PROPERTY)
                        .toString();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Programa Concluído");
                System.exit(0);
            }
            boolean notCancelar = true;
            if (optionConversor == OptionsConversor[0]) {
                try {
                    conversorMoeda.converter();
                } catch (Exception ex) {
                    notCancelar = false;
                }

            } else if (optionConversor == OptionsConversor[1]) {
                try {
                    ConversorTemperatura.converter();
                } catch (Exception ex) {
                    notCancelar = false;
                }
            }
            if (notCancelar) {
                continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar ?", "Conversor",
                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null);
            }
        } while (continuar == 0);

        if (continuar == 1) {
            JOptionPane.showMessageDialog(null, "Programa Finalizado");
        } else {
            JOptionPane.showMessageDialog(null, "Programa Concluído");
        }
        System.exit(0);

    }
}
