package Conversor;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversorTemperatura {

    String[] optionsTemperatura = { "Celsius a Fahrenheit", "Celsius a Kelvin", "Fahrenheit a Celsius",
            "Fahrenheit a Kelvin", "Kelvin a Celsius", "Kelvin a Fahrenheit" };
    String[][] converterDePara = { { "Celsius", "Fahrenheit" }, { "Celsius", "Kelvin" },
            { "Fahrenheit", "Celsius" }, { "Fahrenheit", "Kelvin" }, { "Kelvin", "Celsius" },
            { "Kelvin", "Fahrenheit" } };
    String[][] simboloDePara = { { "°C", "°F" }, { "°C", "K" }, { "°F", "°C" }, { "°F", "K" }, { "K", "°C" },
            { "K", "°F" } };
    Double[] taxaConversao = { 1.8, 1.0, 0.5, 0.5, 1.0, 1.8 };
    Double[][] taxaConversao2 = { { 0.0, 32.0 }, { 273.15, 0.0 }, { -32.0, 0.0 }, { -32.0, 273.15 }, { -273.15, 0.0 },
            { -273.15, 32.0 } };

    public void converter() throws Exception {

        Double valorDouble = 0.0;
        String valor = JOptionPane.showInputDialog(null, "Digite o valor da temperatura: ", "Conversor de Temperatura",
                JOptionPane.QUESTION_MESSAGE);

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

                valor = JOptionPane.showInputDialog(null, "Digite o valor da temperatura: ", "Conversor de temperatura",
                        JOptionPane.QUESTION_MESSAGE);
            }

        } while (valorDouble <= 0);

        String option = JOptionPane.showInputDialog(null, "Escolha a conversão: ", "Conversor de Temperatura",
                JOptionPane.INFORMATION_MESSAGE, null, optionsTemperatura, JOptionPane.MESSAGE_TYPE_PROPERTY)
                .toString();
        System.out.println(option);

        for (int i = 0; i < optionsTemperatura.length; i++) {
            if (option == optionsTemperatura[i]) {
                DecimalFormat df = new DecimalFormat("#.00");
                Double valorConvertido = ((valorDouble + taxaConversao2[i][0]) * taxaConversao[i])
                        + taxaConversao2[i][1];
                String msg = "O valor " + valor + simboloDePara[i][0] + " " + converterDePara[i][0] + " em "
                        + converterDePara[i][1] + " é: " + df.format(valorConvertido) + simboloDePara[i][1];
                JOptionPane.showMessageDialog(null, msg);
            }
        }
    }
}