package com.cursoemvideo.soma;

import javax.swing.*;

public class TelaSoma extends JFrame {

    private JTextField txtN1;
    private JTextField txtN2;
    private JButton btnSoma;
    private JLabel lblResult;
    private JLabel lblMais;

    public TelaSoma() {
        configurarJanela();
        criarComponentes();
        posicionarComponentes();
        configurarEventos();
        exibir();
        }

    private void criarComponentes() {
       txtN1 = new JTextField();
       txtN2 = new JTextField();

       lblMais = new JLabel("+");
       btnSoma = new JButton("=");
       lblResult = new JLabel("0");
    }

    private void configurarJanela() {
        setTitle("Somar Valores");
        setSize(500, 220);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
    }




    private void posicionarComponentes() {
        int y = 80;

        txtN1.setBounds(80,  y, 80, 30);
        lblMais.setBounds(170, y, 20, 30);
        txtN2.setBounds(200, y, 80, 30);
        btnSoma.setBounds(290, y, 50, 30);
        lblResult.setBounds(350, y, 100, 30);

        add(txtN1);
        add(lblMais);
        add(txtN2);
        add(btnSoma);
        add(lblResult);
    }

    private void configurarEventos() {
        btnSoma.addActionListener(e -> {
            try {
                String a = txtN1.getText().trim();
                String b = txtN2.getText().trim();

                int n1 = Integer.parseInt(a);
                int n2 = Integer.parseInt(b);

                int soma = n1 + n2;
                lblResult.setText(String.valueOf(soma));  // JLabel só aceita texto; converte o int para String e mostra no label
            } catch (NumberFormatException erro) { // Catch -> “se der um erro dentro do try, venha pra cá”
                lblResult.setText("Erro");
            }
        });
    }


    private void exibir() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main (String[]args){
            SwingUtilities.invokeLater(TelaSoma::new);
        }
    }

