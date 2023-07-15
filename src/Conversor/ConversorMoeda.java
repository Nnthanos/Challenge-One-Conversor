package Conversor;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class ConversorMoeda {

    static String[] optionsMoeda = { "Reais a Dólar", "Reais a Euro", "Reais a Libras Esterlinas",
            "Reais a Peso argentino", "Reais a Peso Chileno", "Dólar a Reais", "Euro a Reais",
            "Libras Esterlinas a Reais", };
    static String[][] optionDePara = { { "Reais", "Dólar" }, { "Reais", "Euro" }, { "Reais", "Libras Esterlinas" },
            { "Reais", "Peso argentino" }, { "Reais", "Peso Chileno" }, { "Dólar", "Reais" }, { "Euro", "Reais" },
            { "Libras Esterlinas", "Reais" } };
    static String[][] cifraoDePara = { { "R$", "US$" }, { "R$", "€" }, { "R$", "£" }, { "R$", "$" }, { "R$", "$" },
            { "US$", "R$" }, { "€", "R$" }, { "£", "R$" } };
    static Double[] taxaConversao = { 0.19, 0.16, 0.14, 18.15, 139.99, 5.00, 6.22, 7.12 };

    public void converter() throws Exception {

        Double valorDouble = 0.0;
        String valor = JOptionPane.showInputDialog(null, "Digite o valor em reais: ", "Conversor de Moeda",
                JOptionPane.QUESTION_MESSAGE);
        System.out.println(valor);

        do {
            try {
                valorDouble = Double.parseDouble(valor);
                if (valorDouble <= 0) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                if (valor == null) {
                    throw new Exception();
                }
                JOptionPane.showMessageDialog(null, "'" + valor + "' não é um valor válido !Digite um valor válido! ",
                        "ERRO", JOptionPane.ERROR_MESSAGE);

                valor = JOptionPane.showInputDialog(null, "Digite o valor em reais: ", "Conversor de Moeda",
                        JOptionPane.QUESTION_MESSAGE);
            }

        } while (valorDouble <= 0);

        String option = JOptionPane.showInputDialog(null, "Escolha a conversão: ", "Conversor de Moeda",
                JOptionPane.INFORMATION_MESSAGE, null, optionsMoeda, JOptionPane.MESSAGE_TYPE_PROPERTY).toString();
        System.out.println(option);

        for (int i = 0; i < optionsMoeda.length; i++) {
            if (option == optionsMoeda[i]) {
                DecimalFormat df = new DecimalFormat("#.00");
                Double valorConvertido = valorDouble * taxaConversao[i];
                String msg = "O valor " + cifraoDePara[i][0] + " " + valor + " em " + optionDePara[i][0]
                        + " convertido para " + optionDePara[i][1] + " " + cifraoDePara[i][1]
                        + " " +df.format(valorConvertido) + " !";

                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }
}
