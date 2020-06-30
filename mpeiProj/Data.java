package mpeiProj;

public class Data {
	//array que guarda o maior dia possivel num mes
		private static int[] diasMes = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		private int dia, mes, ano;
		private boolean isValid = false;

		public Data(int dia, int mes, int ano) throws IllegalArgumentException {
			if (mes < 1 || mes > 12) {
				throw new IllegalArgumentException("Invalid Month");
			}
			
			if (dia < 1 || dia > diasMes[mes-1]) {
				throw new IllegalArgumentException("Invalid Day");
			}

			if (ano < 1) {
				throw new IllegalArgumentException("Invalid Year");
			}

			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
			this.isValid = true;

		}

		public boolean isValid() {
			return isValid;
		}

		public String toString() {
			return String.format("%2d-%2d-%d", this.dia, this.mes, this.ano);
		}
}

