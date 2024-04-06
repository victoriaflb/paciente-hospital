

import java.text.DecimalFormat;
import java.util.Scanner;

public class Paciente {

    private String nome;
    private String cpf;
    private float altura;
    private float peso;
    private float imc;

    // Construtor vazio
    public Paciente() {
    }

    // Construtor com parâmetros
    public Paciente(String nome, String cpf, float peso, float altura) {
        this.nome = nome;
        this.cpf = cpf;
        this.peso = peso;
        this.altura = altura;
        calcularIMC(); // Calcula o IMC após a definição do peso e altura
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        calcularIMC(); // Recalcula o IMC após a definição do peso
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
        calcularIMC(); // Recalcula o IMC após a definição da altura
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    // Método que calcula o IMC
    private void calcularIMC() {
        if (altura <= 0 || peso <= 0) {
            System.out.println("Altura e peso devem ser valores positivos para calcular o IMC.");
            return;
        }

        imc = (float) (peso / Math.pow(altura, 2));
        DecimalFormat df = new DecimalFormat("##.#"); // Formata para uma casa decimal
        System.out.println("IMC: " + df.format(imc));

        if (imc < 18.5) {
            System.out.println("Abaixo do peso");
        } else if (imc >= 18.5 && imc < 24.9) {
            System.out.println("Peso normal");
        } else if (imc >= 25 && imc < 29.9) {
            System.out.println("Sobrepeso");
        } else if (imc >= 30 && imc < 34.9) {
            System.out.println("Obesidade grau 1");
        } else if (imc >= 35 && imc < 39.9) {
            System.out.println("Obesidade grau 2");
        } else {
            System.out.println("Obesidade grau 3");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("##.#"); // Formata para uma casa decimal
        return "Paciente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                ", imc=" + df.format(imc) + // Formata o IMC com apenas uma casa decimal
                '}';
    }

    // Método que mostra os dados do paciente para o usuário
    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("IMC: " + imc);
    }

    public String confirmarPaciente() {
        String confirmacao;
        Scanner input = new Scanner(System.in);

        System.out.println("Deseja confirmar o paciente? (S/N)");
        confirmacao = input.nextLine();
        input.close();
        // Não é necessário fechar o Scanner aqui
        if (confirmacao.equalsIgnoreCase("S")) {
            return "Alteração realizada com sucesso!";
        } else {
            return "Alteração não realizada!";
        }
    }
}
