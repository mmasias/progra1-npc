import java.util.Scanner;
public class npcBloqueV2{

	public static void main(String[] args){
		int npc[][] = { 
			{2,2},		// Coordenadas X,Y del 1º NPC 
			{5,5}, 		// Coordenadas X,Y del 2º NPC
			{6,9}		// Coordenadas X,Y del 3º NPC
		};
		
		int elMundo[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
				
		boolean hayNPC=false;

		Scanner entrada = new Scanner(System.in);
		String inputUsuario;
		
		for (int minutos=0; minutos<20; minutos++){
			// Codigo experimental de limpieza de pantalla (podria no funcionar en todos los terminales)
				System.out.print("\033[H\033[2J");
				System.out.flush();
			// Fin del codigo experimental

			// INICIO Impresion del mapa
			for (int i=0; i<elMundo.length; i++) {
				for (int j=0; j<elMundo[0].length; j++) {
					
					// Analizo si en la posición a imprimir hay un NPC. 
					// Si lo hay, lo imprimo y me guardo una bandera (hayNPC) 
					// para no imprimir lo que va allí
					hayNPC=false;
					for (int unNPC=0;unNPC<npc.length;unNPC++) {
						if(npc[unNPC][0]==i && npc[unNPC][1]==j){
							System.out.print("^"+unNPC+"^");
							hayNPC=true;
						}
					}
					
					// Verifico la bandera anteriormente configurada, para ver
					// si hay que imprimir lo que toca o no
					if(!hayNPC) { System.out.print(" ' "); }
				}
				System.out.println();
			}
			// FIN Impresion del mapa

			// INICIO gestión del movimiento de los NPC
			for (int unNPC=0; unNPC<npc.length; unNPC++){
				
				int dado=(int)(Math.random()*4)+1;
				
				if(dado==1){npc[unNPC][0]=npc[unNPC][0]+1;} else
				if(dado==2){npc[unNPC][0]=npc[unNPC][0]-1;} else
				if(dado==3){npc[unNPC][1]=npc[unNPC][1]+1;} else
				if(dado==4){npc[unNPC][1]=npc[unNPC][1]-1;} 
			}
			// FIN gestión del movimiento de los NPC

			inputUsuario=entrada.nextLine(); // Pausa para reflexionar... ;)
		}
		

	}
}