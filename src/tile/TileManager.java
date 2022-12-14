package tile;

import main.GamePanel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;


public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];


    public TileManager(GamePanel gp){

        this.gp = gp;

        tile = new Tile[30];
        mapTileNum=new int [gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("/maps/map.txt");

    }

    public void getTileImage(){

        try{

            tile[0]=new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/01.png"));

            tile[1]=new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/02.png"));

            tile[2]=new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/03.png"));

            tile[3]=new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/04.png"));

            tile[4]=new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/05.png"));

            tile[5]=new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/06.png"));

            tile[6]=new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/07.png"));

            tile[7]=new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/08.png"));

            tile[8]=new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/09.png"));

            tile[9]=new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/10.png"));

            tile[10]=new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/11.png"));

            tile[11]=new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/12.png"));

            tile[12]=new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/13.png"));

            tile[13]=new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/14.png"));

            tile[14]=new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/15.png"));

            tile[15]=new Tile();
            tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/16.png"));

            tile[16]=new Tile();
            tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/17.png"));

            tile[17]=new Tile();
            tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/18.png"));

            tile[18]=new Tile();
            tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/19.png"));

            tile[19]=new Tile();
            tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/20.png"));

            tile[20]=new Tile();
            tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/21.png"));

            tile[21]=new Tile();
            tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/22.png"));

            tile[22]=new Tile();
            tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/23.png"));

            tile[23]=new Tile();
            tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/24.png"));

            tile[24]=new Tile();
            tile[24].image = ImageIO.read(getClass().getResourceAsStream("/tiles/25.png"));



        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath){
        try{

            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0 ;
            int row =0;

            while(col< gp.maxScreenCol && row < gp.maxScreenRow){

                String line = br.readLine();

                while(col< gp.maxScreenCol){

                    String numbers[]= line.split(" ");
                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row]=num;
                    col++;
                }

                if (col == gp.maxScreenCol){
                    col=0;
                    row++;
                }


            }
        
                br.close();

        }catch(Exception e){}


    }


    public void draw (Graphics2D g2){

        int col = 0 ;
        int row =0;
        int x=0;
        int y = 0;


        

        while(col< gp.maxScreenCol && row < gp.maxScreenRow){


            int tileNum= mapTileNum[col][row];

            g2.drawImage(tile[tileNum].image,x,y,gp.tileSize,gp.tileSize,null);
            col++;
            x += gp.tileSize;

            if(col== gp.maxScreenCol){
                col=0;
                x=0;
                row++;
                y +=gp.tileSize;
            }
        }

    }   

}
