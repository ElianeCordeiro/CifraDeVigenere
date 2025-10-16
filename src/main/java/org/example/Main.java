package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        String textoClaro = "O \"Pássaro 2x";
        String chave = "Casa";

        String textoCifrado = encriptar(textoClaro, chave);
        System.out.println("O texto cifrado é : " + textoCifrado);

        String textoDecifrado = (decriptar(textoCifrado, chave));
        System.out.println("O texto decifrado é: " + textoDecifrado);
    }


    public static String encriptar(String texto, String chave){
        String textoCifrado = "";

        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789áéíóúâêôã ,;._#*\"-+";

        List<Integer> numericoTexto = new ArrayList();
        List<Integer> numericoChave = new ArrayList();

        if(texto.length()==0 || chave.length() ==0){
            return "Texto ou chave não informados";
        }

        //Verifica caracteres inválidos
        for(int i=0; i <texto.length(); i++){
            if(alfabeto.indexOf(texto.charAt(i)) == -1){
                return "Texto não pode ser cifrado. Caracter inválido";
            }
        }

        //Cria lista com os índices correspondetes para o texto
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<alfabeto.length(); j++){
                if(texto.charAt(i) == alfabeto.charAt(j)){
                    numericoTexto.add(j);
                    break;
                }
            }
        }

        // Cria lista com os índices correspondetes para a chave
        for(int i=0; i<chave.length(); i++){
            for(int j=0; j<alfabeto.length(); j++){
                if(chave.charAt(i) == alfabeto.charAt(j)){
                    numericoChave.add(j);
                    break;
                }
            }
        }

        // Redefine chave para mesmo tamanho do texto
        for(int i=0; i< numericoChave.size(); i++){
            for(int j=numericoChave.size(); j <numericoTexto.size(); j++){
                numericoChave.add(numericoChave.get(i));
                break;
            }
        }

        // Faz o cálculo de módulo e busca o valor no alfabeto adiciona-o ao texto cifrado
        for(int i=0; i<numericoTexto.size(); i++){
            int modulo = (numericoTexto.get(i) + numericoChave.get(i)) % alfabeto.length();
            textoCifrado += alfabeto.charAt(modulo);
        }

        return textoCifrado;
    }

    public static String decriptar(String texto, String chave){
        String textoDecifrado = "";

        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789áéíóúâêôã ,;._#*\"-+";

        List<Integer> numericoTexto = new ArrayList();
        List<Integer> numericoChave = new ArrayList();

        if(texto.length()==0 || chave.length() ==0){
            return "Texto ou chave não informados";
        }

        //Cria lista com os índices correspondetes para o texto
        for(int i=0; i<texto.length(); i++){
            for(int j=0; j<alfabeto.length(); j++){
                if(texto.charAt(i) == alfabeto.charAt(j)){
                    numericoTexto.add(j);
                    break;
                }
            }
        }

        // Cria lista com os índices correspondetes para a chave
        for(int i=0; i<chave.length(); i++){
            for(int j=0; j<alfabeto.length(); j++){
                if(chave.charAt(i) == alfabeto.charAt(j)){
                    numericoChave.add(j);
                    break;
                }
            }
        }

        // Redefine chave para mesmo tamanho do texto
        for(int i=0; i< numericoChave.size(); i++){
            for(int j=numericoChave.size(); j <numericoTexto.size(); j++){
                numericoChave.add(numericoChave.get(i));
                break;
            }
        }

        // Faz o cálculo de módulo e busca o valor no alfabeto adiciona-o ao texto cifrado
        for(int i=0; i<numericoTexto.size(); i++){
            int resultado = (numericoTexto.get(i) - numericoChave.get(i)) + alfabeto.length();
            int modulo = resultado % alfabeto.length();
            textoDecifrado += alfabeto.charAt(modulo);
        }

        return textoDecifrado;
    }
}