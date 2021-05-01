package business;

import java.time.LocalDate;

public class Data {

	private int dia;
	private int mes;
	private int ano;
	private static final String[] DIASEMANA = { "Sabado", "Domingo", "Segunda-feira", "Terça-feira", "Quarta-feira",
			"Quinta-feira", "Sexta-feira" };
	
	public Data() {
		LocalDate data =  LocalDate.now() ;
		this.dia = data.getDayOfMonth();
		this.mes = data.getMonthValue();
		this.ano = data.getYear();
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia)throws ExcecaoDataInvalida {
		if (dia > 0 && dia <= this.diasNoMes()) {
			this.dia = dia;
		} else {
			throw new ExcecaoDataInvalida("dia", dia);
		}
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) throws ExcecaoDataInvalida {
		if (mes > 0 && mes <= 12) {
			this.mes = mes;
		} else {
			throw new ExcecaoDataInvalida("mes", mes);}
		}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano)throws ExcecaoDataInvalida {
		if (ano > 0) {
			this.ano = ano;
		} else {
			throw new ExcecaoDataInvalida("ano", ano);
		}
	}
	public Data(int ano, int mes, int dia) throws ExcecaoDataInvalida{
		
		this.setAno(ano);
    	this.setDia(dia);
    	this.setMes(mes);
    	
	}
	
	public boolean eAnoBissexto(){
        boolean confAno = false;
        if((this.ano % 100 !=0 && this.ano % 4 ==0) || this.ano % 400 ==0){
            confAno = true;
        }
        return confAno;
    }
	
	 public int diasNoMes(){
	        int diasNoMes = 31;
	        if(this.mes == 2 ){
	            if(eAnoBissexto()){
	                diasNoMes = 29;
	            }
	            else{
	                diasNoMes = 28;
	            }
	        }
	        else if (this.mes == 11 || this.mes == 9 || this.mes == 6 || this.mes == 4){
	            diasNoMes = 30;
	        }
	        return diasNoMes;
	    }
	 
	 public void adicionaDias(int dias) {
			if (dias <= 0) {
				return;
			}

			this.dia += dias;

			while (this.dia > this.diasNoMes()) {
				this.dia -= this.diasNoMes();
				this.mes++;

				if (this.mes > 12) {
					this.ano++;
					this.mes = 1;
				}
			}
		}

		public void proximoDia() {
			this.adicionaDias(1);
		}
		
		public String diaDaSemana() {
			int k = this.dia + (2 * this.mes) + (3 * (this.mes + 1)) / 5 + this.ano + this.ano / 4 - this.ano / 100
					+ this.ano / 400 + 2;
			return Data.DIASEMANA[k % 7];
		}

		public boolean dataRecente(int dia, int mes, int ano) {
	    	boolean isrecente = false;
	    	if((this.ano > ano) || (this.ano == ano && this.mes> mes)|| (this.ano == ano && this.mes == mes && this.dia > dia)) {
	    	
	    		isrecente = true;
	    		
	    	}
	    	
	    	return isrecente;
	    }
		
		@Override
		public String toString() {
			return "Data:" + this.dia + " / " + this.mes + " / " + this.ano + "";
		}
		
		
		
	 
	 
	
}
