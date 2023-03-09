import java.util.Arrays;

public class Bender {
    private int filX, colX, fil$, col$, filT, colT;
    public char[][] mapita;
    public char[][] guardaTps;
    public Bender(String mapa) {
        buscarPosiciones(mapa);
    }

    public void buscarPosiciones(String mapa) {
        String[] mapaLineas = mapa.split("\n");
        int numFilas = mapaLineas.length;
        int numCols = mapaLineas[0].length();
        mapita = new char[numFilas][numCols];


        for (int f = 0; f < numFilas; f++) {
            for (int c = 0; c < numCols; c++) {
                mapita[f][c] = mapaLineas[f].charAt(c);

                if (mapita[f][c] == 'X') {
                    filX = f;
                    colX = c;
                }
                if (mapita[f][c] == '$') {
                    fil$ = f;
                    col$ = c;
                }
                if (mapita[f][c] == 'T') {
                    filT = f;
                    colT = c;
                }
            }
        }
    }

    public String run() {
        String resultado = "";

        while (mapita[filX][colX] != mapita[fil$][col$]) {
            if (mapita[filX + 1][colX] == '$' || mapita[filX + 1][colX] == ' ') {
                while (mapita[filX + 1][colX] != '#') {
                    if (mapita[filX][colX] == mapita[fil$][col$]){
                        break;
                    }
                    resultado += "S";
                    filX++;
                }
            } else if (mapita[filX][colX + 1] == '$' || mapita[filX][colX + 1] == ' ') {
                while (mapita[filX][colX + 1] != '#') {
                    if (mapita[filX][colX] == mapita[fil$][col$]){
                        break;
                    }
                resultado += "E";
                colX++;
                }
            } else if (mapita[filX - 1][colX] == '$' || mapita[filX - 1][colX] == ' ') {
                while (mapita[filX - 1][colX] != '#') {
                    if (mapita[filX][colX] == mapita[fil$][col$]){
                        break;
                    }
                    resultado += "N";
                    filX--;
                }
            } else if (mapita[filX][colX - 1] == '$' || mapita[filX][colX - 1] == ' ') {
                while (mapita[filX][colX - 1] != '#') {
                    if (mapita[filX][colX] == mapita[fil$][col$]){
                        break;
                    }
                    resultado += "W";
                    colX--;
                }
            } if (mapita[filX][colX] == 'T') {

            }
        }
        return resultado;
    }
}
