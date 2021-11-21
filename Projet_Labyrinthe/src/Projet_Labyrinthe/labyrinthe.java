package Projet_Labyrinthe;

public class labyrinthe 
{
	int grid_size[] = new int[2];
	boolean grid[][];
	int grid_val[][];
	 
	int cX = 0;
	int cY = 0;
	 
	int deltaX = 0;
	int deltaY = 0;
	 
	int size = 6;
	 
	boolean over = false;
	 
	void setup(){
	  grid_size[0] = 64;
	  grid_size[1] = 36;
	  size(900, 500);
	  grid = new boolean[2*grid_size[0]+1][2*grid_size[1]+1];
	  grid_val = new int[grid_size[0]][grid_size[1]];
	  for(int i = 0; i < 2*grid_size[0]+1; i++){
	    for(int j = 0; j < 2*grid_size[1]+1; j++){
	      grid[i][j] = true;
	      if(i%2 == 1 && j%2 == 1) grid[i][j] = false;
	    }
	  }
	  grid_val[cX][cY] = -1;
	  grid[grid_size[0]+1][0] = false;
	  grid[grid_size[0]+1][2*grid_size[1]] = false;
	  frameRate(50);
	}
	 
	void draw(){
	  background(0);
	  deltaX = (width-size*(2*grid_size[0]+1))/2;
	  deltaY = (height-size*(2*grid_size[1]+1))/2;
	  noStroke();
	  for(int i = 0; i < 2*grid_size[0]+1; i++){
	    for(int j = 0; j < 2*grid_size[1]+1; j++){
	      fill(230);
	      if((i+j)%2 == 0) fill(255);
	      if(grid[i][j]) fill(30);
	      rect(deltaX+size*i, deltaY+size*j, size, size);
	    }
	  }
	  if(!over){
	    fill(0, 150);
	    rect(0, 0, width, height);
	    fill(0, 255, 0);
	    rect(deltaX+size+2*size*cX, deltaY+size+2*size*cY, size, size);
	    for(int i = 0; i < 50; i++) iterate();
	  }
	}
	 
	void iterate(){
	  int dir[] = new int[4];
	  int count_dir = 0;
	  if(cX < grid_size[0]-1){
	    if(grid_val[cX+1][cY] == 0 && grid[2+cX*2][1+cY*2]){
	      dir[count_dir] = 1;
	      count_dir++;
	    }
	  }
	  if(cY > 0){
	    if(grid_val[cX][cY-1] == 0 && grid[1+cX*2][cY*2]){
	      dir[count_dir] = 2;
	      count_dir++;
	    }
	  }
	  if(cX > 0){
	    if(grid_val[cX-1][cY] == 0 && grid[cX*2][1+cY*2]){
	      dir[count_dir] = 3;
	      count_dir++;
	    }
	  }
	  if(cY < grid_size[1]-1){
	    if(grid_val[cX][cY+1] == 0 && grid[1+cX*2][2+cY*2]){
	      dir[count_dir] = 4;
	      count_dir++;
	    }
	  }
	  if(count_dir > 0){
	    int i = int(random(0, count_dir));
	    if(dir[i] == 1){
	      grid[2+cX*2][1+cY*2] = false;
	      cX++;
	    }
	    else if(dir[i] == 2){
	      grid[1+cX*2][cY*2] = false;
	      cY--;
	    }
	    else if(dir[i] == 3){
	      grid[cX*2][1+cY*2] = false;
	      cX--;
	    }
	    else{
	      grid[1+cX*2][2+cY*2] = false;
	      cY++;
	    }
	    grid_val[cX][cY] = dir[i];
	  }
	  else{
	    if(grid_val[cX][cY] == 1) cX--;
	    else if(grid_val[cX][cY] == 2) cY++;
	    else if(grid_val[cX][cY] == 3) cX++;
	    else if(grid_val[cX][cY] == 4) cY--;
	    else over = true;
	  }
	}
}
