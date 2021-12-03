#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

	FILE *archivo;
	char carAnterior[5];
	int cont = 0, i = 0, suma = 0;
	int datos[2000] = {0};

	archivo = fopen("input.txt","r");
	if (archivo == NULL)
    {
        printf("\nError de apertura del archivo. \n\n");
        exit(1);
    }
    else
    {
 	    while (feof(archivo) == 0)
 	    {
            fgets(carAnterior,6,archivo);
            datos[i] = atoi(carAnterior);
            i++;
 	    }
 	    fclose(archivo);

 	    FILE *fp;
        fp = fopen ( "salida.txt", "w" );
        char cad[6];
 	    for(i = 0; i < 1998; i++){
            suma = datos[i] + datos[i + 1] + datos[i + 2];
            itoa(suma,cad,10);
            strcat(cad, "\n");
            fputs(cad, fp);
            suma = 0;
 	    }
 	    fclose ( fp );
    }


return 0;
}
