#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

	FILE *archivo;
	char cad[20]={0};
	int d = 0;
	int f = 0;
    int tam = 0;
	archivo = fopen("input.txt","r");
	if (archivo == NULL)
    {
        printf("\nError de apertura del archivo. \n\n");
        exit(1);
    }
    else
    {
 	    while (!feof(archivo))
 	    {
 	        fgets(cad,20,archivo);
            tam = strlen(cad);
            if(cad[0] == 'f'){
                f += cad[tam-2] - '0';
            }
            else if(cad[0] == 'd'){
                d += cad[tam-2] - '0';
            }
            else if(cad[0] == 'u'){
                d -= cad[tam-2] - '0';
            }
        }
    }
    fclose(archivo);
    printf("%d\n",f);
    printf("%d",d);




return 0;
}
