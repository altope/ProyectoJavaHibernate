package funciones;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Funciones {

	//  METODO QUE EXPRESA FECHA EN FORMATO NUESTRO CADA DIA EN LETRAS  ///////////////////

	public static String fechaForm(GregorianCalendar fecha){
		int anyo=0; 	int mes=0;  	int dia=0;  	int diaSema=0;
		String day ="";
		anyo = fecha.get(GregorianCalendar.YEAR);
		mes = fecha.get(GregorianCalendar.MONTH)+1;
		dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
		diaSema = fecha.get(GregorianCalendar.DAY_OF_WEEK);

		switch(diaSema) {
		case 1:
			day = "Domingo";
			break;
		case 2:
			day = "Lunes";
			break;
		case 3:
			day = "Martes";
			break;
		case 4:
			day ="Miercoles";
			break;
		case 5:
			day = "Jueves";
			break;
		case 6:
			day = "Viernes";
			break;   
		case 7:
			day ="Sabado";
		}
		return ("el "+ day + " - " + dia +"/" + mes + "/" + anyo);
	}
	////////////////////////////////////////////////////////////////////////////

	//  METODO PASAR LOS MESES A LETRAS   //////////////////////////////////

	public static String mesForm(GregorianCalendar fecha){
		String month ="";
		int diaMes = fecha.get(GregorianCalendar.MONTH);
		switch(diaMes){
		case 0:
		{
			month="Enero";
			break;
		}
		case 1:
		{
			month="Febrero";
			break;
		}
		case 2:
		{
			month="Marzo";
			break;
		}
		case 3:
		{
			month="Abril";
			break;
		}
		case 4:
		{
			month="Mayo";
			break;
		}
		case 5:
		{
			month="Junio";
			break;
		}
		case 6:
		{
			month="Julio";
			break;
		}
		case 7:
		{
			month="Agosto";
			break;
		}
		case 8:
		{
			month="Septiembre";
			break;
		}
		case 9:
		{
			month="Octubre";
			break;
		}
		case 10:
		{
			month="Noviembre";
			break;
		}
		case 11:
		{
			month="Diciembre";
			break;
		}
		default:
		{
			month="Error";
			break;
		}
		}
		return month;
	}
	///////////////////////////////////////////////////////////////////////////////////

	//  METODO CALCULAR LAS EDADES   DEVUELVE  STRING  ////////////////////////////////////////////////////////////////

	public static String calcularEdad (GregorianCalendar fechaActual, GregorianCalendar fechaDeNacimiento) {
		int anios=0;  int meses=0;  int dias=0;

		int yA = fechaActual.get(GregorianCalendar.YEAR);
		int mAct = fechaActual.get(GregorianCalendar.MONTH)+1;
		int dAct = fechaActual.get(GregorianCalendar.DAY_OF_MONTH);

		int yNac = fechaDeNacimiento.get(GregorianCalendar.YEAR);
		int mNac = fechaDeNacimiento.get(GregorianCalendar.MONTH);  		
		int dNac = fechaDeNacimiento.get(GregorianCalendar.DAY_OF_MONTH);

		GregorianCalendar fechaCumple= new GregorianCalendar(yA, mNac, dNac); 

		anios =  fechaActual.get(GregorianCalendar.YEAR) - fechaDeNacimiento.get(GregorianCalendar.YEAR);  // aca calculamos la edad como diferencia en años entre fechaNac y fechaActual

		if (fechaCumple.before(fechaActual)){   // ahora vemos las diferencias Si ya pasó el cumpleaños: La diferencia en años sigue igual?

			dias = dAct - dNac;
			meses = mAct - mNac;

			if (dias < 0  && dNac < 31){
				dias = 30 + dias;
				meses--;
			}	  			
			if (dias < 0 && dNac == 31){
				dias = 31 + dias;
				meses--;
			}
			if ( dias > 0 && meses <= 1){
				anios =  yA - yNac ;
			}
			if (dias == 0){
				meses = mAct - mNac;
			}
		} 

		if(fechaCumple.after(fechaActual)){
			// Si todavia no llegó el cumpleaños: La diferencia en años sigue igual?
			anios --;		
			dias = dAct - dNac;   // Y dias?
			meses = 11 - mNac + mAct;

			if (dias > 0 || dias == 0){
				meses = 12 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  		
			}	 
			if (dias < 0 && dNac < 31){
				dias = 30 + dias;
				meses = 11 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  
			}
			if (dias < 0 && dNac == 31){
				dias = 31 + dias;
				meses = 11 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  
			}  		 		
			if (fechaCumple == fechaActual){             // Como calculamos la diferencia sabiendo lo anterior? es el dia del cumpleaños!   Hay que hacer algo? 

				meses = 0;
				dias  = 0;		
			}
		}  				
		return "    Tiene: " + anios + " años  " + meses + " meses  y  " + dias + " dias";      

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////

	// METODO CALCULAR LAS EDADES. DEVUELVE INT    ////////////////////////////////////////////////////

	public static int calculaEdad(GregorianCalendar fHoy, GregorianCalendar fechaNacimiento) {
		int anios=0;	int meses=0;	int dias=0;

		int yA = fHoy.get(GregorianCalendar.YEAR);
		int mAct = fHoy.get(GregorianCalendar.MONTH)+1;
		int dAct = fHoy.get(GregorianCalendar.DAY_OF_MONTH);
		
		// EN ESTA PARTE PODEMOS USAR EL getFechaNacimiento EN CASO DE PASAR UN SOLO PARAMETRO 
		int yNac = fechaNacimiento.get(GregorianCalendar.YEAR);
		int mNac = fechaNacimiento.get(GregorianCalendar.MONTH)+1;   // +1  		
		int dNac = fechaNacimiento.get(GregorianCalendar.DAY_OF_MONTH);

		GregorianCalendar fechaCumple= new GregorianCalendar(yA, mNac, dNac); 

		anios =  fHoy.get(GregorianCalendar.YEAR) - fechaNacimiento.get(GregorianCalendar.YEAR);  // aca calculamos la edad como diferencia en años entre fechaNac y fechaActual

		if (fechaCumple.before(fHoy)){   // ahora vemos las diferencias Si ya pasó el cumpleaños: La diferencia en años sigue igual?

			dias = dAct - dNac;
			meses = mAct - mNac;

			if (dias < 0  && dNac < 31){
				dias = 30 + dias;
				meses--;
			}	  			
			if (dias < 0 && dNac == 31){
				dias = 31 + dias;
				meses--;
			}
			if ( dias > 0 && meses <= 1){
				anios =  yA - yNac ;
			}
			if (dias == 0){
				meses = mAct - mNac;
			}
		} 
		if(fechaCumple.after(fHoy)){
			// Si todavia no llegó el cumpleaños: La diferencia en años sigue igual?
			anios --;		
			dias = dAct - dNac;   // Y dias?
			meses = 11 - mNac + mAct;

			if (dias > 0 || dias == 0){
				meses = 12 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  		
			}	 
			if (dias < 0 && dNac < 31){
				dias = 30 + dias;
				meses = 11 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  
			}
			if (dias < 0 && dNac == 31){
				dias = 31 + dias;
				meses = 11 - mNac + mAct;
				if (meses == 12){
					meses = 0;
					anios ++;
				}	  
			}  		 		
			if (fechaCumple == fHoy){             // Como calculamos la diferencia sabiendo lo anterior? es el dia del cumpleaños!   Hay que hacer algo? 

				meses = 0;
				dias  = 0;		
			}
		}  				
		return anios ;      

	}

	//METODO DE IMPRESION DE LISTAS FUERA DEL MAIN
	/*	public static void impresion(List<nombreClaseObjeto> lista){ 
		for ( int p = 0; p < lista.size(); p++) {
			System. out.println(lista.get(p));
		}
	}  */


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////   TRABAJO  PRATICO  DE  LA  GUIA  2   /////////////////////////////////////////////////////

	// 1 - METODO esBisiesto //////////////////////////////////////////////////////////////////////

	public static boolean esBisiesto(int anio){
		if ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0)){
			return true;
		}
		else {
			return false;
		} // end_else
	} // end_public_esBiesto

	// 2 - METODO traerAnio ///////////////////////////////////////////////////////////////////////

	public static int traerAnio(GregorianCalendar f){
		return f.get(Calendar.YEAR); 
	}

	// 3 - METODO traerMes ////////////////////////////////////////////////////////////////////////

	public static int traerMes(GregorianCalendar f){
		return f.get(Calendar.MONTH)+1;
	}

	// 4 - METODOtraerDia ////////////////////////////////////////////////////////////////////////

	public static int traerDia(GregorianCalendar f){
		return f.get(Calendar.DAY_OF_MONTH);
	}

	// 4.1 - METODO traerHora  ////////////////////////////////////////////////////////////////////

	public static int traerHora(GregorianCalendar f){
		return f.get(Calendar.HOUR);
	}

	// 4.2 - METODO traerMinuto  ////////////////////////////////////////////////////////////////////

	public static int traerMinuto(GregorianCalendar f){
		return f.get(Calendar.MINUTE);
	}

	// 4.3 - METODO traerSegundo  ////////////////////////////////////////////////////////////////////

	public static int traerSegundo(GregorianCalendar f){
		return f.get(Calendar.SECOND);
	}	

	// 5 - METODO esFechaValida ///////////////////////////////////////////////////////////////////

	public static boolean esFechaValida(int anio, int mes, int dia){
		boolean valida = false;	
		if((mes-1 < 12) && (dia < 32)){
			if( (mes-1 == 0 || mes-1 == 2 || mes-1 == 4 || mes-1 == 6 || mes-1 == 7 || mes-1 == 9 || mes-1 == 11) && (dia < 32)) {
				valida = true;
			} 
			else if( (mes-1 == 3 || mes-1 == 5 || mes-1 == 8 || mes-1 == 10) && (dia < 31) ){
				valida = true;
			} 
			else if ((mes-1 == 1) && (esBisiesto(anio) == true) && (dia == 29)){
				valida = true;
			} 
			else if ((mes-1 == 1) && (dia < 29)) {
				valida = true;
			} 
		} 
		return valida;
	} // end_public_esFechaValida	

	// 6 - METODO traerFecha RETURN GREGORIANCALENDAR  //////////////////////////////////////////////////////////////////////

	public static GregorianCalendar traerFecha(int anio, int mes, int dia){
		GregorianCalendar fecha = new GregorianCalendar(anio, (mes-1), dia);  //LE RESTO 1 AL MES PARA QUE JAVA LO TOME CORRECTAMENTE
		return fecha;
	} // end_public_traerFecha

	// 6.1 - METODO traeFecha RECIBE (DESDE STRING) GREGORIANCALENDAR DEVUELVE STRING   ///////////////////////////////////////
	public static String traeFechaCorta(GregorianCalendar fecha){		
		int anio=0, mes=0, dia=0;
		anio = fecha.get(GregorianCalendar.YEAR);
		mes = fecha.get(GregorianCalendar.MONTH)+1;
		dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
		return (dia +"/" + mes + "/" + anio);	
	}

	// 7 - METODO traerFecha RECIBE STRING RETURN GREGORIANCALENDAR ////////////////////////////////////////////////////////////////

	public static GregorianCalendar traerFecha(String fecha){
		String[] j= fecha.split("/");//con split indico donde se divide la cadena para formar una array de cadenas
		//como la fecha en String tiene el formato --/--/-- tendre un array de 3 posiciones
		//inicializo variables en formato int de dia mes y anio
		int dia = 0; int mes = 0; int anio = 0;
		dia = Integer.parseInt(j[0]);//la instruccion integer.parseint convierte un String en entero
		// en dia convierto a entero el primer espacio de la fecha --/ y lo asigno a la posicion 0 del array
		mes = Integer.parseInt(j[1]); // en mes convierto a entero el primer espacio de la fecha /--/ y lo asigno a la posicion 1 del array
		anio = Integer.parseInt(j[2]); // en anio convierto a entero el primer espacio de la fecha /-- y lo asigno a la posicion 2 del array
		GregorianCalendar f = new GregorianCalendar(anio, (mes)-1, dia);  //retorno f en formato gregorianCalendar
		return f;
	} // end_public


	///////// A GREGORIAN CALENDAR	 ////////////// TOMA LA FECHA DEL USUARIO Y LA ADAPTA A GREG-CALENDAR
	public static GregorianCalendar aGregorianCalendar(int anio, int mes, int dia){
		GregorianCalendar fecha = new GregorianCalendar(anio, (mes)-1, dia);
		fecha.setLenient(false);
		return fecha;
	} // end_public_aGregorianCalendar
	//////////////////////////////////////////////////////////////////////////////

///// METODO aGregorianCalendar SOBRECARGADO /////////////////////////////////////////////////////
    
    public static GregorianCalendar aGregorianCalendar(int anio, int mes, int dia, int hora, int minutos, int segundos){
    	GregorianCalendar fecha = new GregorianCalendar(anio, (mes)-1, dia);
		fecha.set(Calendar.HOUR_OF_DAY, hora);
		fecha.set(Calendar.MINUTE, minutos);
		fecha.set(Calendar.SECOND, segundos);
    	fecha.setLenient(false);
    	return fecha;
    } // end_public_aGregorianCalendar	
////////////////////////////////////////////////////////////////////////////////////////////
    
	// 8 - METODO fechaCorta RECIBE GREGPRIAN CALENDAR  DEVUELVE UN STRING TIPO dd/mm/yyyy   //////////////////////////////////////////

	public static String fechaCorta(GregorianCalendar fecha){
		return (fecha.get(GregorianCalendar.DAY_OF_MONTH) +"/" + (fecha.get(GregorianCalendar.MONTH)+1) + 
				"/" + fecha.get(GregorianCalendar.YEAR));
	} // end_public_fechaCorta

	// 8.1 METODO  traerFechaCorta  ////////   DEVUELVE UN STRING TIPO dd/mm/yyyy    /////////////////////////

	public static String traerFechaCorta(GregorianCalendar fecha){
		int anio=0, mes=0, dia=0;
		anio = fecha.get(GregorianCalendar.YEAR);
		mes = fecha.get(GregorianCalendar.MONTH)+1;
		dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
		return (dia +"/" + ((mes)) + "/" + anio);
	}
	/**  TRAER FECHA CORTA CON LocalDate  **/
	
	public static String traerFechaCorta(LocalDate fecha){
		int anio=0, mes=0, dia=0;
		anio = fecha.getYear();
		mes = fecha.getMonthValue();
		dia = fecha.getDayOfMonth();
		return (dia +"/" + mes + "/" + anio);
	}


	// 9 - METODO traerFechaCortaHora  //// DEVUELVE UN STRING TIPO dd/mm/yyyy hh:mm:ss  /////////////////////////////////////

	public static String traerFechaCortaHora ( GregorianCalendar fecha ){		                          
		return (fecha.get(GregorianCalendar.DAY_OF_MONTH) +"/" + (fecha.get(GregorianCalendar.MONTH)+1) + "/" + fecha.get(GregorianCalendar.YEAR) +
				" "+ fecha.get(GregorianCalendar.HOUR_OF_DAY)+ ":"+ fecha.get(GregorianCalendar.MINUTE)+":"+ fecha.get(GregorianCalendar.SECOND));
	}  

	// 9.1 - METODO traerFecha RECIBE GREGPRIAN CALENDAR  DEVUELVE UN STRING TIPO dd/mm/yyyy  ////////////////

	public static String traeFecha(GregorianCalendar f){
		f.setLenient(false);
		int anyo = 0;   int mes = 0;   int dia = 0;

		anyo = f.get(GregorianCalendar.YEAR);
		mes = f.get(GregorianCalendar.MONTH)+1;
		dia = f.get(GregorianCalendar.DAY_OF_MONTH);
		return "Hoy es: " + dia +"/" + mes + "/" + anyo + "  y " + calculoBisiesto(f);     
	}

	// 9.2 - METODO CALCULO BISISESTO  DEVUELVE STRING //////////////////////////////////

	public static String calculoBisiesto(GregorianCalendar f){
		GregorianCalendar este = new GregorianCalendar();
		int anyo = este.get(GregorianCalendar.YEAR); 
		if ((anyo % 4 == 0) && (anyo % 100 == 0)  || (anyo % 400 == 0)){
			return "El año es bisiesto";
		}else {
			return  "El año no es bisiesto";	
		}		
	}

	// 9.3 - METODO traerFechaCortaHoraMin  PREDETERMINADO     ////////////////////////////////////

	public static String traerFechaCortaHoraMin(GregorianCalendar fecha){
		String f =(fecha.get(GregorianCalendar.DAY_OF_MONTH) + "/" 	//armo el String fecha con todos los datos que necesito se muestren
				+ (fecha.get(GregorianCalendar.MONTH)+1)	
				+ "/" + fecha.get(GregorianCalendar.YEAR) 
				+ "-" + fecha.get(GregorianCalendar.HOUR) 
				+ ":" + fecha.get(GregorianCalendar.MINUTE)+ ":" + fecha.get(GregorianCalendar.SECOND));

		return f;	//retorno fecha en formato String
	}

	// 9.4 - METODO calculaDiasEntreDosFechas ////////////////////////////

	public int calculaDiasEntreDosFechas(){
		int dias=0;
		GregorianCalendar c = new GregorianCalendar();
		GregorianCalendar fechaInicio = new GregorianCalendar(2011, 03, 1);
		GregorianCalendar fechaFin= new GregorianCalendar(2011, 03, 15);		
		//aca puedo poner condiciones if
		c.setTimeInMillis(fechaFin.getTime().getTime()- fechaInicio.getTime().getTime());

		dias=c.get(GregorianCalendar.DAY_OF_YEAR);

		return dias;				
	}


	// 9.5 - METODO traerFechaHora   ///  DEVUELVE GREGORIAN CALENDAR FECHA

	@SuppressWarnings("deprecation")
	public static String traerFechaHora (GregorianCalendar fecha){
		GregorianCalendar f1 = new GregorianCalendar(fecha.get(GregorianCalendar.YEAR), 
				(fecha.get(GregorianCalendar.MONTH)),
				fecha.get(GregorianCalendar.DAY_OF_MONTH),fecha.get(GregorianCalendar.HOUR_OF_DAY),
				fecha.get(GregorianCalendar.MINUTE), fecha.get(GregorianCalendar.SECOND));
		return f1.getTime().toLocaleString();
	}


	//  10 - METODO traerFechaProximo (GregorianCalendar fecha, int cantDias) :GregorianCalendar  LE SUMA CANTIDAD DE DIAS
	//	EJEMPLO: traerFechaProximo (new GregorianCalendar(2016,7,21) , 7) ------> new GregorianCalendar(2016,7,28)

	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias){
		int dia = fecha.get(GregorianCalendar.DAY_OF_MONTH) + cantDias;
		fecha = aGregorianCalendar(fecha.get(GregorianCalendar.YEAR), fecha.get(GregorianCalendar.MONTH)+1, dia);
		return fecha;
	}


	//  10.1 -  METODO  traerFechaProx  ///////////////////////////////////////////////////////////////////		

	public static String traerFechaProx(GregorianCalendar fecha, int cantDias){
		fecha.add(GregorianCalendar.DAY_OF_MONTH, cantDias); //USO ADD PARA AGREGARLE LOS DIAS QUE QUIERO E MI FECHA
		return traerFechaCorta(fecha);		//USO EL METODO TRAER FECHA CORTA PARA TRAER LA FECHA CON LOS DIAS AGREGADOS
	}
	//////////////////////////////////////////////////////////////////////////


	// 11 - METODO esDiaHabil (GregorianCalendar fecha) : boolean  (fecha de hoy) //  CONSIDERAMOS HABIL DE LUNES A VIERNES   //////////////////

	public static boolean esDiaHabil(GregorianCalendar fecha){
		boolean habil = false;
		int dia = 0;
		fecha = aGregorianCalendar(fecha.get(GregorianCalendar.YEAR), fecha.get(GregorianCalendar.MONTH)+1, fecha.get(GregorianCalendar.DAY_OF_MONTH));
		dia = fecha.get(GregorianCalendar.DAY_OF_WEEK);
		if(dia>1 && dia <7 ){
			habil = true;
		} // end_if
		return habil;
	} // end_public   


	//  11.1 - METODO  esHabil/////////////////////////////////////////////////////////////////////

	public static boolean esHabil(GregorianCalendar fecha){
		boolean habil = false;
		int dia = 0;
		dia = fecha.get(GregorianCalendar.DAY_OF_WEEK)-1;
		if(dia >=2 && dia <= 6){
			habil = true;
		} // end_if
		return habil;
	} // end_public

	///////////////////////////////////////////////////////////////////////////


	// 12 - METODO traerDiaDeLaSemana   DEVUELVE EL DIA DE LA SEMANA EN LETRAS  /////////////////////////////////////////////////////////

	public static String traerDiaDeLaSemana(GregorianCalendar fecha){
		int dia = 0; //inicializo una variable del tipo int para el dia de la semana del gregorianCalendar
		dia = fecha.get(GregorianCalendar.DAY_OF_WEEK)-1;
		//creo un array con los dias de la semana
		String vdia[] = {"Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"}; 
		return vdia[dia]; //al array de dias de la semana le asigno la posicion del entero dia
	} // end_publi


	// 13 - METODO traerMesEnLetras  DEVUELVE EL MES EN LETRAS////////////////////////////////////////////////////////

	public static String traerMesEnLetras(GregorianCalendar fecha){
		int mes = 0;
		mes = fecha.get(GregorianCalendar.MONTH); //traigo el mes de la fecha
		//en un array de string cargo los meses
		String vmes[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
				"Septiembre","Octubre","Noviembre","Diciembre"};
		return vmes[mes]; //el mes de la fecha lo convierto en la posicion de mi array y me devuelve el mes en letras
	} // end_public	

	// 13.1 - METODO traerMesLetras SOBRECARGADO//////////////////////////////////////
	public static String traerMesLetras(int anio, int mes){
		int mesint = 0;  //en un array de string cargo los meses
		String mes1[] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio",	
				"Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		//el mes de la fecha lo convierto en la posicion de mi array y me devuelve el mes en letras
		return mes1[mesint+1]; 
	}

	// 13.2 - METODO enVigencia 
	// DETERMINA SI LA FECHA PASADA POR PARAMETRO ESTA ENTRE DOS FECHAS DETERMINADAS POR EL METODO ///////////

	public static boolean enVigencia(GregorianCalendar fecha){
		boolean vigente=false;
		GregorianCalendar fechaIni =new GregorianCalendar(2016,8,6); 
		GregorianCalendar fechaFin =new GregorianCalendar(2016,9,12); 
		if(fecha.after(fechaIni)&&fecha.before(fechaFin)){
			vigente=true;
		}
		return vigente;
	}	
	
// 13.3 - METODO enVigencia 
// DETERMINA SI LAS FECHAS PASADAS POR PARAMETRO TIENEN ENTRE ELLAS LA FECHA OBTENIDA POR EL METODO ///////////	
	public static boolean enVigencia(GregorianCalendar f1, GregorianCalendar f2){
		boolean valida = false;
		GregorianCalendar fecha = new GregorianCalendar();
		if(f1.after(fecha ) && f2.before(fecha)){
			valida=true;
		}
		return valida;
	}
	
	// 13.4 -METODO esAnterior
	// DETERMINA SI LA FECHA ES ANTERIOR A LA ACTUAL  //////////

	public static boolean esAnterior(GregorianCalendar fecha1) throws Exception{
		boolean anterior = false;
		GregorianCalendar fecha =new GregorianCalendar(); 
		if(fecha1.before(fecha)){
			anterior=true;
		}else{
			throw new Exception("La Fecha NO es valida");
		}
		return anterior;
	}	

	// 14 - METODO traerFechaLarga ////////////////////////////////////////////////////////////////

	public static String traerFechaLarga(GregorianCalendar fecha){
		int dia = 0;
		int anio = 0;
		dia = fecha.get(GregorianCalendar.DAY_OF_MONTH);
		anio = fecha.get(GregorianCalendar.YEAR);
		return traerDiaDeLaSemana(fecha) + " " + dia + " de " + traerMesEnLetras(fecha) + " del " + anio;
	} // end_public

	// 14.1 - METODO traeFechaLarga ////////////////////////////////////////////////////////////////

	public static String traeFechaLarga(GregorianCalendar fecha){

		return ("Hoy es "+ Funciones.fechaForm(fecha) +"  "+ fecha.get(GregorianCalendar.DAY_OF_MONTH) + 
				"  de  " + Funciones.mesForm(fecha) + "  de  " + fecha.get(GregorianCalendar.YEAR));
	}

	// 15 - METODO SON FECHAS IGUALES ///////////////////////////////////////////////////////////////

	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean iguales = false;
		if(fecha.get(GregorianCalendar.DAY_OF_MONTH) == fecha1.get(GregorianCalendar.DAY_OF_MONTH) &&
				fecha.get(GregorianCalendar.MONTH) == fecha1.get(GregorianCalendar.MONTH) &&
				fecha.get(GregorianCalendar.YEAR) == fecha1.get(GregorianCalendar.YEAR) ) {
			iguales = true;
		} // end_if
		return iguales;
	} // end_public


	//  15.1 - METODO  fechasIguales//////////////////////////////////////////////////////////////

	//PASO COMO PARAMETROS LOS DOS OBJETOS FECHA 
	public static boolean fechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){ 
		boolean sonIguales = false;  //inicializo en false la variable sonIguales
		if(fecha.equals(fecha1)){  //comparo las dos fechas con equals
			sonIguales = true;	//si son iguales se pone en true la variable sonIguales
		}
		return sonIguales; 	//retorno sonIguales		
	}
	//////////////////////////////////////////////////////////////////////////


	// 16 - METODO SON FECHAS HORAS IGUALES ///////////////////////////////////////////////////////////////

	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean iguales = false;
		if( fecha.get(GregorianCalendar.YEAR) == fecha1.get(GregorianCalendar.YEAR) &&
				fecha.get(GregorianCalendar.MONTH) == fecha1.get(GregorianCalendar.MONTH) &&
				fecha.get(GregorianCalendar.DAY_OF_MONTH) == fecha1.get(GregorianCalendar.DAY_OF_MONTH) &&
				fecha.get(GregorianCalendar.HOUR) == fecha1.get(GregorianCalendar.HOUR) &&
				fecha.get(GregorianCalendar.MINUTE) == fecha1.get(GregorianCalendar.MINUTE) &&
				fecha.get(GregorianCalendar.SECOND) == fecha1.get(GregorianCalendar.SECOND) ) {
			iguales = true;
		} // end_if
		return iguales;
	} // end_public

	//  16.1 - METODO  fechasHorasIguales/////////////////////////////////////////

	public static boolean fechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean sonIguales = false;  //inicializo en false la variable sonIguales
		if(fecha.equals(fecha1)){  //comparo las dos fechas con equals
			sonIguales = true;	//si son iguales se pone en true la variable sonIguales
		}
		return sonIguales; 	//retorno sonIguales		
	}


	// 16.2 - METODO sonFechasIguales PARA QUE DE ERROR    /////////////////////////////////////////////

	public static boolean sonFechasHorasIgualesError(GregorianCalendar fecha, GregorianCalendar fecha1){
		boolean iguales = false;
		int minutos = fecha1.get(GregorianCalendar.MINUTE) + 1;
		if( fecha.get(GregorianCalendar.YEAR) == fecha1.get(GregorianCalendar.YEAR) &&
				fecha.get(GregorianCalendar.MONTH) == fecha1.get(GregorianCalendar.MONTH) &&
				fecha.get(GregorianCalendar.DAY_OF_MONTH) == fecha1.get(GregorianCalendar.DAY_OF_MONTH) &&
				fecha.get(GregorianCalendar.HOUR) == fecha1.get(GregorianCalendar.HOUR) &&
				fecha.get(GregorianCalendar.MINUTE) == (minutos) &&
				fecha.get(GregorianCalendar.SECOND) == fecha1.get(GregorianCalendar.SECOND) ) {
			iguales = true;
		} // end_if
		return iguales;
	} // end_public

	// 17 - METODO traerCantDiasDeUnMes    ///////////////////////////////////////////////////////////

	public static int traerCantDiasDeUnMes(int anio, int mes){
		int cantidad = 0;
		if( (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) ) {
			cantidad = 31;
		} // end_if
		if( (mes == 4 || mes == 6 || mes == 9 || mes == 11) ){
			cantidad = 30;
		} // end_if
		if(mes == 2) {
			cantidad = 28;
			if(esBisiesto(anio) == true){
				cantidad = 29;
			} // end_if
		} // end_if
		return cantidad;
	} // end_public

	// 18 - METODO CORTO FECHA VALIDA USANDO ===>  METODO CANT DE DIAS DEL MES  //////////////////////

	public static boolean esFechaValida2(int anio, int mes, int dia){
		boolean valida = true;
		if ( (anio < 1) || (mes < 1 || mes > 12) || (dia < 1 || dia > traerCantDiasDeUnMes(anio, mes)) ){
			valida = false;
		} // end_if
		return valida;
	} // end_public_esFechaValida2


	// 19 - METODO aproximar2Decimal //////////////////////////////////////////////////////////////

	public static double aproximar2Decimal(double valor){
		return Math.rint(valor*100)/100; 
	} // end_public


	// 20 - METODO esNumero (boolean)   ///////////////////////////////////////////

	public static boolean esNumero(char c) throws Exception{
		int i = 0;  
		boolean numero = false;
		String diccionarioNum = "0123456789";

		char arrayNum[] = diccionarioNum.toCharArray();
		int n = diccionarioNum.length();
		for (i = 0;  i<n; i++){
			if (c == arrayNum[i]){
				numero = true;
			}
		}
		if (numero == false){
			throw new Exception("ERROR: No es un numero");  
		}
		return numero;
	}

	// 20.1 METODO   esNum   SIN TROWS EXCEPTION   /////////////////////////////////////////////

	public static boolean esNum(char c){
		int i=0;
		boolean num= false;
		String tablaNum = "0123456789";
		char arrayNum[] = tablaNum.toCharArray();
		int size = tablaNum.length();
		for ( i = 0; i<size; i++){
			if(c == arrayNum[i]){
				num= true;
			}
		}
		return num;		
	}

	// 21 - METODO    esCaracter    //////////////////////////////////////////

	public static boolean esCaracter(char c) throws Exception{
		int i = 0;
		boolean caracter = false;
		String diccionarioLetras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ ";
		int n = diccionarioLetras.length();
		char arrayLetras[] = diccionarioLetras.toCharArray();
		for (i = 0; i<n; i++){
			if (c == arrayLetras[i]){
				caracter = true;
			}
		}
		if (caracter == false){ 
			throw new Exception("ERROR: No es una Letra");
		}        
		return caracter;
	}

	// 21.1 -  METODO   esCaract   SIN TROWS EXCEPTION  /////////////////////////////////////////

	public static boolean esCaract(char c){
		int i=0;
		boolean caracter=false;
		String tablaLetras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		int size = tablaLetras.length();
		char arrayLetras[] = tablaLetras.toCharArray();
		for (i = 0; i < size; i++){
			if(c == arrayLetras[i]){
				caracter=true;
			}
		}
		return caracter;
	}

	// 22 - METODO    esCadNum    //////////////////////////////////////////

	public static boolean esCadNum(String cadena) throws Exception{
		boolean numero = false;
		int i;
		int q = cadena.length();
		char arrayCad[] = cadena.toCharArray();
		for (i=0; i<q; i++){
			if( esNumero(arrayCad[i])){
				numero = true;
			}else{
				throw new Exception("ERROR: No es cadena de Numeros");
			}
		}
		return numero;
	}

	// 22.1 METODO esCadenaNumeros SIN TROWS EXCEPTION ///////////////////////////////////

	public static boolean esCadNumeros(String cadena){
		boolean numero = false;
		int i = 0;    
		int esLetra=0;
		int size = cadena.length();
		char arrayCad[] = cadena.toCharArray();
		for (i=0;i<size;i++){
			if( esCaract(arrayCad[i])== true){
				esLetra= esLetra +1;        		
			} 
		} 
		if (esLetra == 0){
			numero= true;
		}
		return numero;
	} 

	// 23 - METODO   esCadLetras     /////////////////////////////////////////    
	public static boolean esCadLetras(String cadena) throws Exception{
		boolean caracter = false;
		//	cadena = cadena.toLowerCase();
		int i;
		int q = cadena.length();
		char arrayCad[] = cadena.toCharArray();
		for (i=0; i<q; i++){
			if( esCaracter(arrayCad[i])){
				caracter = true;
			}
			else{
				throw new Exception("ERROR: No es cadena de Letras");
			}
		}
		return caracter;
	}

	// 23.1 - METODO  esCadenaLetras SIN TROWS EXCEPTION   ///////////////////////////////////////

	public static boolean esCadLetra(String cadena){
		boolean escadena = false;
		int i = 0;
		int  esNumero = 0; //la variable entera esNumero en cero indica que no hay ningun numero en la cadena
		int size = cadena.length();
		char arrayCad[] = cadena.toCharArray();
		for (i=0; i<size; i++){
			if( (esNum(arrayCad[i])) == true ){ ///si esNumero me da verdadero entonces
				esNumero = esNumero + 1; //incremento en 1 la variable entera esNumero
			} 
		} //termino de recorrer la cadena con el for 
		if(esNumero == 0){ //si esNumero no se incremento entonces significa que la cadena es de letras
			escadena = true;
		}
		return escadena;
	} 

	// 23.3  METODO   sonDiferentes  ////////// PARA PRACTICO DE CETA 
	// DETERMINA SI LAS DOS CADENAS SON IGUALES, EN ESTE CASO COMPRADOR Y VENDEDOR

	public static boolean sonDiferentes(String cad1, String cad2, String cad3, String cad4) throws Exception{
		boolean distintos = false;
		if( (!cad1.equals(cad2)) || (!cad3.equals(cad4))){
			distintos = true;
		}
		else{
			throw new Exception("ERROR: Comprador y vendedor son el mismo");
		}
		return distintos;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////


	// 24 - METODO convertirADouble   ////////////////////////////////////////////////
	public static double convertirADouble(int n){
		//String.valueOf(n) PASA EL NUMERO n A TIPO STRING
		return Double.parseDouble(String.valueOf(n)); // DESDE UN STRING DEVUELVE UN DOUBLE
	}

	// 24a - METODO convertirAString   ////////////////////////////////////////////////
	// valueOf CONVIERTE UN NUMERO EN STRING (EN ESTE CASO)
	/*
	 * El método valueOf es un método sobrecargado aplicable a numerosas clases de Java 
	 * y que permite realizar conversiones de tipos. Veamos algunos ejemplos de uso.
	 */
	public static String convertirAString(int n){

		String str;					//DECLARAMOS LA VARIABLE str DONDE GUARDAR EL NUEVO STRING

		str = String.valueOf(n);		//PASAMOS EL NUMERO n A LA VARIABLE String str

		return str;					//DEVUELVE EL NUMERO CONVERTIDO A String
	}
	/**********************************************************************************************************/
	
	 public static String imprimeFecha(GregorianCalendar FechaHoraSalida){
		  String dia = Funciones.traerDiaDeLaSemana(FechaHoraSalida);
		  String mes = Funciones.traerMesEnLetras(FechaHoraSalida);
		  int diaNumero = FechaHoraSalida.get(Calendar.DAY_OF_MONTH);
		  int anio = FechaHoraSalida.get(Calendar.YEAR);
		  int hora = FechaHoraSalida.get(Calendar.HOUR_OF_DAY);
		  int minuto = FechaHoraSalida.get(Calendar.MINUTE);
		  return dia + " " + diaNumero + " de " + mes + " de " + anio + " - " + hora + ":" + minuto;
		 } // end_public_imprimeFecha
	 
	/*****************************************************************************************************************/
	 
/********************************************************************************************************************/
		//cuenta de digitos
		public static String verificarCuenta(String cuenta) throws Exception {
	
			String nCuenta = cuenta.substring(0,10) + cuenta.substring(11); //String sin barra
			int[] digitos = new int [nCuenta.length()];
			if(digitos.length != 11){ // 11 DIGITOS | POSICIONES DE 0 A 11
				throw new Exception("1)ERROR: Nro.de.Cuenta invalido, no tiene 11 digitos " + cuenta);
			} // end_if
			for (int i = 0; i< (nCuenta.length()-1); i++){
				digitos[i] = nCuenta.charAt(i) - '0'; // con el for voy cargando cada numero en una posicion del array
			} // end_for
			int suma = 0; 
			int	longitud = digitos.length;
			for(int i = 0; i < longitud-1; i++) {
			    int digito = digitos[i];
			   
			    if(i % 2 == 1) {
			    	digito = digito * 2;
			    	
				    if(digito > 9){
				    	digito = digito - 9;				    	
				    } // end_if
			//	    System.out.println(digito);
			    	suma = suma + digito;
			    } // end_if
			    else{
			    	suma = suma + digito;
		//	    	System.out.println(suma);
			    }
			} // end_for
	//		System.out.println("\n"+ suma);  // prueba de resultado
			suma = suma * 9;
			suma = suma % 10;
			int verificador = Integer.parseInt(cuenta.substring(11));
			if(suma != verificador){
				throw new Exception ("\n2)ERROR: Numero de cuenta invalido: "+  cuenta);
			} // end_if
			return cuenta;
		} // end_public_verificacionCuenta

/*****************************************************************************************************************/
	// METODO ES PAR
	public static boolean esPar(int n){
		boolean par;
		if( n % 2 == 0){
			par = true;
		}
		else{
			par = false;
		}			
		return par; //un solo return por metodo
	}

	//**********************************************************
	// METODO NUMERO PRIMO():boolean

	public static boolean esPrimo(int n){
		boolean primo = true;
		int s=2;
		if ( n % s == 0 || n == 1 ){
			if ( n % s == 0 ){
				primo = false;
			} 
			s++;
		} 
		return primo;
	} 
	/*******************************************************************************************/
	//**********************************************************
	// METODO pasarBase2 (): String

	public static String pasarBase2(int n){
		String resultado="";
		while(n >= 1){	// mientras n no sea menor a 1 hacemos
			resultado= n%2 + resultado; // en el String resultado vamos cargando el resto
			// de hacer la division por 2 del numero y cada vuelta el nuevo resto se 
			// carga adelante del anterior formando una cadena o String de atras hacia adelante
			n=n/2;	//luego dividimos el numero por 2 y almacenamos el resultado en n
			//para poder seguir dividiendo el numero
		}
		return resultado; //devuelve el String con el numero binario
	}

	//*******************************************************
	// METODO para calcular factorial 
	public static int calcularFactorial(int n) {
		int factorial=1;		//inicializo factorial en 1 (entonces si n=0 el factorial sera 1				
		if (n>0){		//si n es mayor que cero
			for (int i = 1; i <= n; i++) {	//recorro desde 1 hasta n incrementando en 1
				factorial *= i;   //multiplico el numero por todos los numeros incrementados desde 1 hasta n
			}
		}
		if (n<0){		//si n es menor que cero entonces
			factorial = -1;	//factorial será menos uno (-1)
		}
		return factorial;	//retorno el valor de factorial
	}
	/////////////////////////////   2019   /////////////////////////////////////////
	
	// METODO factorial  2019
	public static int factorial(int n) {
		if (n<=1){		//si n es menor o iugal 1
			return 1;	//factorial será uno (1)
		}else{
			return n * factorial(n-1);
		}	
	}
	
/**	public static String calcularMayor(Persona p1, Persona p2){
		if (p1.calcularEdad() > p2.calcularEdad()){
			return (p1.getNombre());
		}else{
			return (p2.getNombre());
		}
	}  **/

	///////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////

	//25 - METODO validarSexo   //////////////////////////////////////////////////////
	public static boolean validarSexo(char sex) throws Exception{
		boolean sexoValido=false;
		if(sex=='M'||sex=='F' || sex=='m' || sex=='f'){			
			sexoValido=true;
		}else{
			throw new Exception("Sexo mal ingresado");
		}
		return sexoValido;
	}

	//25.1 METODO  esSexoValido    /////////////////////////////////////
	public static boolean esSexoValido(char c){ 
		String diccionario_sexo = "FfMm";
		boolean sexoValido = false;
		int i = 0;
		for (i= 0; i<(diccionario_sexo.length()); i++){ 
			if (c == diccionario_sexo.charAt(i)){
				sexoValido = true;
			}
		}
		return sexoValido;  							
	}	

	////////////   TEST CUIL INCORPORADO A FUNCIONES   //////////////////////////////////////////////////

	///////  METODO arrayCuil ///////////////////////////////////////////////////////////////////////////

	public static int[] arrayCuil(String stringCuil){
		int xcuil[] = new int [3];
		String[] j= stringCuil.split("-");
		xcuil[0] = Integer.parseInt(j[0]);
		xcuil[1] = Integer.parseInt(j[1]);
		xcuil[2] = Integer.parseInt(j[2]);
		int cuil[] = new int [11];
		long xdni = 0;
		xdni = xcuil[1];
		int n = 0;
		int carga = 0;
		long previo = 0;
		long divisor = 10000000;
		int verificador = xcuil[0];
		previo = verificador/10;
		carga = (int) previo;
		cuil[0] = carga;
		previo = verificador%10;
		carga = (int) previo;
		cuil[1] = carga;
		for(n=2;n<=9;n++){
			previo = xdni/divisor;
			carga = (int) previo;
			cuil[n] = carga; 
			previo = xdni%divisor;
			xdni = (long) previo;
			divisor = divisor/10;
		} // end_for
		cuil[10] = xcuil[2];
		return cuil;
	} // end_public_arrayCuil

	/////  METODO validarCuil   /////////////////////////////////////////////////////////////////////////

	public static boolean validarCuil(String stringCuil) throws Exception {
		boolean verifica = false;
		int[] cuil = arrayCuil(stringCuil); 
		if (cuil.length != 11) { 
			throw new Exception("El Cuil NO es valido");
		} // end_if
		else {
			int[] mult = { 5, 4, 3, 2, 7, 6, 5, 4, 3, 2 };
			int valor1 = 0;

			for (int i = 0; i < mult.length; i++) {
				valor1 += cuil[i] * mult[i];
			} // end_for
			int mod = 0;   int digito = 0;
			mod = valor1 % 11; // NOS DA EL VALOR ENTERO DEL RESTO DE LA DIVISION
			int valor3 = 11 - mod;
			if (valor3 == 11) {
				digito = 0;
			} // end_if 
			else if (valor3 == 10) {
				digito = 9;
			} // end_else_if
			else {
				digito = valor3;
			} // end_else
			if (digito == cuil[10]){
				verifica = true;
			}else{
				throw new Exception("El Cuil NO es valido");
			}
		} // end_else
		return verifica;
	} // end_public_validarCuil

	/////  METODO validarDominio   /////////////////////////////////////////////////////////////////////////

	public static boolean validarDominio(String dominio) throws Exception{
		boolean patente = false;
		if(Funciones.esCadLetra(dominio.substring(0, 2)) && Funciones.esCadNumeros(dominio.substring(3, 5))){
			patente = true;
		}else{
			throw new Exception("Error: No es un dominio valido");
		}
		return patente;
	}

	////////////////////////////  FIN TRABAJO PRATICO DE LA GUIA  2    ////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	////////////////////////////////  PRACTICO 4 ORDENAMIENTO DE ARRAYS Y USO DE INTERFACES   /////////////////////////// 	
	//  GENERAR ARRAY ///////////////
	public static int[] generarArray(int inicio, int fin, int cantidad){   //  GENERAMOS UNA SECUENCIA ORDENADA Y LUEGO LA MEZCLAMOS	
		int[] array=crearSecuencia(inicio, fin, cantidad);             // ESTO ES PARA EVITAR ELEMENTOS REPETIDOS
		mezclarArray(array);
		return array;
	}

	//  MEZCLAR ARRAY  //////////////////////////////										
	private static void mezclarArray(int[] array){    //  RECIBE UN ARRAY Y LO MEZCLA (INTERCAMBIA LOS ELEMENTOS)
		int indice, temp;
		Random random = new Random();                  //  EN EL LUGAR, AL AZAR 
		for (int i = array.length - 1; i > 0; i--){
			indice = random.nextInt(i + 1);
			temp = array[indice];
			array[indice] = array[i];
			array[i] = temp;
		}
	}


	// CREA UNA SECUENCIA DE CANTIDAD DE ENTEROS DE INICIO A FIN SE GENERA CON INTERVALOS IGUALES ENTRE VALORES

	public static int[] crearSecuencia(int inicio, int fin, int cantidad){
		int[] array = new int[cantidad];
		int salto=(fin-inicio)/cantidad;
		for (int i=0; inicio < fin; i++){
			array[i] = inicio+=salto;
		}
		return array;
	}
	// MOSTRAMOS EL ARRAY  ////////////////////////////		
	public static void mostrarArray(String mensaje, int[] array){
		System.out.println(mensaje+Arrays.toString(array));
	}

	// METODO PARA INTERCAMBIAR EN UN ARRAY SE USA EN VARIOS METODOS DE ORDENAMIENTO  ///////////////////
	protected void intercambiar(int[] array, int indice1, int indice2){  // METODO AYUDANTE, VARIOS ALGORITMOS LO USAN		                  
		int tmp = array[indice1];         // INTERCAMBIA LOS VALORES DE LAS POSICIONES   
		array[indice1] = array[indice2];   // DE LOS INDICE 1 E INDICE 2 EN EL ARRAY  
		array[indice2] = tmp;
	}

	//  METODO DE LLAMADA A ORDENAR ARRAYS  CON BURBUJA, QUICK SORT, Y TODOS  ///////////
	public int[] ordenar(int[] array) {
		return quickSort(array, 0, array.length);  // SOLO SE CAMBIA AQUI POR EL ORDENAMIENTO QUE USEMOS
	}

	// VERSION RECURSIVA DE QUICKSORT  ////////

	public int[] quickSort(int[] arr, int comienzo, int fin) {
		if (fin - comienzo < 2) return arr;			 //CLAUSULA DE FINALIZACION
		int p = comienzo + ((fin-comienzo)/2);
		p = particionar(arr,p,comienzo,fin);
		quickSort(arr, comienzo, p);
		quickSort(arr, p+1, fin);
		return arr;
	}

	//  METODO PARA EFECTUAR LA PARTICION EN EL PIVOTE  ////////////////

	private int particionar(int[] array, int p, int comienzo, int fin) {
		int c = comienzo;
		int f = fin - 2;
		int pivote = array[p];
		intercambiar(array,p,fin-1);
		while (c < f) {
			if (array[c] < pivote) {
				c++;
			} else if (array[f] >= pivote) {
				f--;
			} else {
				intercambiar(array,c,f);
			}
		}
		int indice = f;
		if (array[f] < pivote) indice++;
		intercambiar(array,fin-1,indice);
		return indice;
	}
	////////////////////////   FIN DE ORDENAMIENTO "QUICK SORT"   ///////////////////////////////

	////////////////// METODO DE ORDENAMIENTO "BURBUJA"  ////////////////////////////////////////////

	public int[] burbuja(int[] array) {
		int lenD = array.length;  // DEFINO VARIABLE DE LONGITUD DEL ARRAY
		boolean ordenado=false;
		for(int i=0; i<lenD && !ordenado; i++){  //RECORRO EL ARRAY MIENTRAS ORDENADO = FALSE
			ordenado=true;
			for(int j=(lenD-1); j>=(i+1); j--){  //RECORRO EL ARRAY DESDE ATRAS MIENTRAS 
				if(array[j] < array[j-1]){  // SI ES MENOR AL ANTERIOR, 
					ordenado=false;				// NO ESTA ORDENADO
					intercambiar(array,j,j-1);  // APLICO FUNCION INTERCAMBIAR POSICION EN ARRAY
				}
			}// END FOR
		} //END FOR
		return array;
	} // END PUBLIC INT BURBUJA

	////////////////////////////////////   FIN METODO DE ORDENAMIENTO "BURBUJA"  ////////////////////////////////////////////	

	// METODO DE INSERCION	////////////////////////////////////////////
	public int[] insercion(int[] array) {   // METODO DE INSERCION		
		int p, j;
		int aux;
		for (p = 1; p < array.length; p++){ 			   //  DESDE EL SEGUNDO ELEMENTO HASTA EL FINAL,
			aux = array[p]; 								//   GUARDAMOS EL ELEMENTO Y 
			j = p - 1;				 						//  EMPEZAMOS A COMPROBAR CON EL ANTERIOR  
			while ((j >= 0) && (aux < array[j])){ 	//  MIENTRAS QUEDEN POSICIONES Y EL VALOR DE AUX SEA MENOR QUE LOS DE LA IZQUIERDA,  
				array[j + 1] = array[j];     			// SE DESPLAZA A LA DERECHA EL VALOR DEL ARRAY
				j--;                  					
			}
			array[j + 1] = aux; 				//  Y COLOCAMOS AUX EN SU LUGAR REEMPLAZANDOLO   
		}	
		return array;
	}
	///////////////////  FIN METODO DE INSERCION	////////////////////////////////////////////

	//  METODO JAVA DE ORDENACION POR SELECCION   ///////////////////////////////////////
	public int[] seleccion(int[] array) {          //  METODO JAVA DE ORDENACION POR SELECCION 
		int i, j, menor, pos;
		for (i = 0; i < array.length - 1; i++) {   // TOMAMOS COMO MENOR AL PRIMERO DE LOS ELEMENTOS   
			menor = array[i];						 //  QUE QUEDAN POR ORDENAR 
			pos = i; 							   // Y GUARDAMOS SU POSICION

			for (j = i + 1; j < array.length; j++){ 	//  BUSCAMOS EN EL RESTO DEL ARRAY    
				if (array[j] < menor) {				  // ALGUN ELEMENTO MENOR QUE EL ACTUAL SI ES MENOR
					menor = array[j]; 				 // LO ASIGNAMOS COMO EL NUEVO MENOR
					pos = j;                        //  GUARDAMOS LA POSICION DEL MENOR
				}
			}
			if (pos != i){							 // SI LA POS DEL MENOR YA NO ES LA DEL i ORIGINAL
				intercambiar(array, i, pos);        //  SE LLAMA A INTERCAMBIAR POSICIONES   
			}									//  ENTRE EL MENOR INDICE ANTERIOR Y EL NUEVO
		}
		return array;
	}


	////////////////////////////////////////  FIN  PRACTICO 4   /////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////

/***********************************************************************************************	
 * try{
			
	}catch(Exception e){
		System.out.println( "Excepcion: " + e.getMessage());
	}
/*********************************************************************************************
  //METODO DE IMPRESION DE LISTAS FUERA DEL MAIN
	public static void impresion(List<Pelicula> lista){ 
		for ( int i = 0; i < lista.size(); i++) {
			System. out.println(lista.get(i));
		}
	}        

	// METODO EQUALS REDUCIDO
	 public boolean equals(Producto producto){
		return (idProducto == producto.getIdProducto());
	}   
	
	public boolean equals(Cliente obj){
		return (idCliente == obj.getIdCliente());
	}  
	
// 1) traerCliente(long dni): Cliente
	public Cliente traerCliente(long dni) throws Exception{
		int i=0;
		boolean encontrado = false;
		while( i < lstClientes.size() && encontrado == false){
			if(lstClientes.get(i).getDni()== dni){
				encontrado = true;
			}else{
				i++;
			}
		}
		if(encontrado == false){
			throw new Exception("No existe el cliente con dni:"+dni+"buscado");
		}
		return lstClientes.get(i);
	}
	
// 2) agregarCliente(String nombre, String apellido, String email, long dni): boolean
	public boolean agregarCliente(String nombre, String apellido, String email, long dni) throws Exception{
		boolean agregado = false;
		int idCliente = 0; int i = 0;
		for(i=0; i<lstClientes.size(); i++){
			if (lstClientes.get(i).getDni() == dni){
				agregado = true;
				throw new Exception ("El cliente con dni: "+dni+" ya se encuentra en la Lista.");
			} // end_if
			if(idCliente < lstClientes.get(i).getIdCliente()){
				idCliente = lstClientes.get(i).getIdCliente();
			}
		} // end for
		idCliente++;
		if(agregado == false){				
			lstClientes.add(new Cliente(idCliente, nombre, apellido, email, dni));
			agregado = true;	
		}
		return agregado;
	}	
	
//  100) ELIMINAR CLIENTE  /////////////////////////////////
	public boolean eliminarCliente(Cliente cliente) throws Exception{
		boolean resultado = false;
		for(int i=0;i<lstClientes.size();i++){
			if (lstClientes.get(i).getDni() == cliente.getDni()){
				lstClientes.remove(i);
				resultado = true;				
			} // end_if
			if(resultado == false){
				throw new Exception ("El cliente con dni: "+cliente.getDni()+" no se encuentra en la Lista.");
			}
		} // end_for	
		return resultado;
	}
	
// 9) METODO agregarCompra(Cliente cliente, Producto producto, GregorianCalenda fechaHora, double cantidad): boolean
	public boolean agregarCompra(Cliente cliente, Producto producto,GregorianCalendar fechaHora, double cantidad)throws Exception{
		boolean agregado = false;     int i=0;
		for(i=0; i<lstTarjetas.size(); i++){
			if(lstTarjetas.get(i).getCliente().equals(cliente)){
			//if(lstCompras.get(i).getProducto().equals(producto)){
				agregado = true;
				lstTarjetas.get(i).getLstCompras().add(new Compra(producto, fechaHora, cantidad));
			}
		}
		if(!agregado){
			throw new Exception("\nNo se agrego la compra");
		}
		return agregado;
	}
	
// 10) traerCompras(Cliente cliente): List<Compra>
	public List<Compra> traerCompras(Cliente cliente){
		List<Compra> lista = new ArrayList <Compra>();
		int i =0, j =0;
		for(i=0; i<lstTarjetas.size(); i++){
			if(lstTarjetas.get(i).getCliente().equals(cliente)){
				for(j=0; j<lstTarjetas.get(i).getLstCompras().size(); j++){
					lista.add(lstTarjetas.get(i).getLstCompras().get(j));
				}
			}
		}// end for	
		return lista;
	}

////////////// TIEMPO DE EJECUCION  ////////////////////////////////////////////////////////////////////////
 
 public int tiempoDeEjecucion() {
		int tiempo = 0;   
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(fechaDeFin.getTime().getTime() - fechaDeInicio.getTime().getTime());
		tiempo=c.get(GregorianCalendar.DAY_OF_YEAR);
		if(tiempo == 365 ){
		 	tiempo = 0;
		}
		return tiempo;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	 *********************************************************************************************************/

	///////////////////////////////////////   METODOS PARA MATRICES   /////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////

	private double[][] matrizA;

	@Override
	// METODO TOSTRING PARA MATRIZ BIDIMENSIONAL//////////
	public String toString() {
		String texto = "\n";
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA.length; j++) {
				// texto+="\t "+matrizA[i][j];
				texto += "\t " + (double) Math.round(1000 * matrizA[i][j]) / 1000;
			}
			texto += "\n";
		}
		texto += "\n";
		return texto;
	}/////////////////////////////////////////////////////

	// METODO SUMA DE MATRICES
	public double[][] sumar(double[][] matrizB) { // recibe una matriz double
		double[][] nuevam = new double[matrizA.length][matrizA.length];
		for (int i = 0; i < matrizA.length; i++) { // recorre la matriz objeto [i]
			for (int j = 0; j < matrizA.length; j++) { // recorre la matriz objeto [j]
				nuevam[i][j] = matrizA[i][j] + matrizB[i][j]; // en la matriz double se ira
				// sumando el valor de la matriz objeto a la matriz objeto
				// que recibo cuando ambos subindices coincidan
			}
		}
		return nuevam;
	}

	// METODO RESTA DE MATRICES
	public double[][] restar(double[][] matrizB) { // recibe una matriz double
		double[][] nuevam = new double[matrizA.length][matrizA.length];
		for (int i = 0; i < matrizA.length; i++) { // recorre la matriz objeto [i]
			for (int j = 0; j < matrizA.length; j++) { // recorre la matriz objeto [j]
				nuevam[i][j] = matrizA[i][j] - matrizB[i][j]; // en la matriz double se ira
				// restando el valor de la matriz objeto a la matriz objeto que recibo
				// cuando ambos subindices coincidan
			}
		}
		return nuevam;
	}

	// METODO TRANSPUESTA
	public double[][] matrizTranspuesta(){
		double[][]nuevam=new double[matrizA.length][matrizA.length];
		for(int i=0; i<matrizA.length; i++){
			for(int j=0; j<matrizA.length; j++){
				nuevam[i][j]=matrizA[j][i];
			}    
		}
		return nuevam;	// retorno de la nueva matriz, sino no funciona
	}
	/*
	public double[][] matrizTranspuesta(double[][] matriz) {
		double[][] nuevam = new double[matriz[0].length][matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++)
				nuevam[i][j] = matriz[j][i];
		}
		return nuevam;
	}   */

	// PRODUCTO DE UN ESCALAR POR UNA MATRIZ
	public double[][] multiplicar(double n) {
		double[][] nuevam = new double[matrizA.length][matrizA.length];
		for (int i = 0; i < matrizA.length; i++){
			for (int j = 0; j < matrizA.length; j++){
				nuevam[i][j] = matrizA[i][j] * n;
			}
		}   
		return matrizA;
	} 

	// PRODUCTO DE MATRICES
	public double[][] multiplicar(double[][] matrizB) {
		double[][] nuevam = new double[matrizA.length][matrizA.length];
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizB.length; j++) {
				for (int k = 0; k < matrizA.length; k++) { // puede ser columnasA o
					// filasB ya que deben ser iguales entonces tb podriamos poner for ( int k = 0; k < matrizB.length; k++
					// ) que son las filas de la matriz B
					nuevam[i][j] += matrizA[i][k] * matrizB[k][j]; 
					// el signo += implica que en cada posicion de la nueva matriz vamos a ir haciendo la sumatoria de los productos de cada
					// elemento de la fila de la matriz a por cada elemento de la columna de la matriz b
				}
			}
		}
		return nuevam;
	}



	//////////////////////////////////   FIN METODOS PARA MATRICES   ////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



}  //  END PUBLIC CLASS FUNCIONES

/*

if (cadena.matches("[0-9]*")){
       	System.out.println("\nEs una cadena de Numeros");
       	numero = true;
       }else{
       	  System.out.println("\nNo es cadena de Numeros");
       	  throw new Exception("ERROR: No es cadena de numeros");
       } 

  if (cadena.matches("[a-z]+")){
       	System.out.println("\nEs una cadena de Letras");
       	numero = true;
       }else{
       	  System.out.println("\nNo es una cadena Letras");
       	  throw new Exception("ERROR: No es cadena de Letras");
       }
       
 */






