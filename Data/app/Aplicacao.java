package app;

import business.*;


public class Aplicacao {

	public static void main(String[] args) {
		
		try {
			
			Data hoje = new Data();
			System.out.println("Dia da semana: " + hoje.diaDaSemana());
			System.out.println("Dias no mes: " + hoje.diasNoMes());
			hoje.proximoDia();
			System.out.println("Amanhã: " + hoje.toString());
			
			Data data = new Data(2020,2,19);
			System.out.println("Dias no mes: " + data.diasNoMes());
			if(data.dataRecente(14, 2,2020)) {
				System.out.println(""+data.toString()+" é mais recente");
			}
			data.adicionaDias(17);
			System.out.println("Nova data: "+ data.toString());
			

		} 
		catch (ExcecaoDataInvalida e) {
			e.getMessage();
			e.printStackTrace();
		} 

		
	}
}
