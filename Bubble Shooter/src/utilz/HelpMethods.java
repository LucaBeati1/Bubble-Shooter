package utilz;

import java.awt.Color;
import java.util.Random;

import entities.Ball;
import main.Game;
import grid.GameGrid;

public class HelpMethods {
	
	public static int chain = 0;
	
	public static boolean wallCollision(float x, float width) {
		if(x < 400 || x + width > 800) 
		return true;
		else
			return false;
	}
	
	public static Color randomColor() {
		
		Random random = new Random();
		int x = random.nextInt(6);
		Color color = Color.GREEN;
		switch (x) {
		case 0:
			color = Color.GREEN;
			break;
		case 1:
			color =Color.BLUE;
			break;
		case 2:
			color =Color.RED;
			break;
		case 3:
			color =Color.YELLOW;
			break;
		case 4:
			color =Color.MAGENTA;
			break;
		case 5:
			color =Color.ORANGE;
			break;
		}
		return color;
		
	}
	
	public static double distance(float x1,float y1,float x2, float y2) {

		 return Math.sqrt(Math.pow(x1 - x2, 2)+ (Math.pow(y1 - y2, 2)));
	}
	
	public static void bubblePop(GameGrid grid) {
		
		collisionGrid(grid.Balls, grid.iLength, grid.jLength);
		
		if(chain >= 3) {
			for(int i = 0; i < grid.Balls.length; i++)
				for(int j = 0; j < grid.Balls[i].length; j++) {
					
					if(grid.Balls[i][j].checked == true) {
						grid.Balls[i][j].checked = false;
						grid.Balls[i][j].empty = true;
					}
				}
		}
		else {
			
			for(int i = 0; i < grid.Balls.length; i++)
				for(int j = 0; j < grid.Balls[i].length; j++) {
					grid.Balls[i][j].checked = false;
				}
		}
		chain = 0;
	}
	
	public static void collisionGrid(Ball[][] Balls, int i, int j) {
		
		int a = 0;
		int b = 0;
		
		for(int y = 0; y < Balls.length; y++) {
			if(Balls[i][1].y - 43 == Balls[y][1].y){
				a = y;
			}
		}
		
		for(int y = 0; y < Balls.length; y++) {
			if(Balls[i][1].y + 43 == Balls[y][1].y){
				b = y;
			}
		}
		
		if(Balls[i].length == 8) {
				try {
					if(Balls[a][j].color == Balls[i][j].color &&
							Balls[a][j].checked == false &&
							Balls[a][j].empty == false) {
						Balls[a][j].checked = true;
						chain ++;
						collisionGrid(Balls, a, j);
					}
					}
					catch(Exception e) {
					}
				try {
					if(Balls[a][j-1].color == Balls[i][j].color &&
							Balls[a][j-1].checked == false &&
							Balls[a][j-1].empty == false) {
						Balls[a][j-1].checked = true;
						chain ++;
						collisionGrid(Balls, a, j-1);
					}
				    }
				    catch(Exception e) {
				    }
				try {
					if(Balls[i][j-1].color == Balls[i][j].color &&
							Balls[i][j-1].checked == false &&
							Balls[i][j-1].empty == false) {
						Balls[i][j-1].checked = true;
						chain ++;
						collisionGrid(Balls, i, j-1);
					}
			        }
			        catch(Exception e) {
			        }
				try {
					if(Balls[i][j+1].color == Balls[i][j].color &&
							Balls[i][j+1].checked == false &&
							Balls[i][j+1].empty == false) {
						Balls[i][j+1].checked = true;
						chain ++;
						collisionGrid(Balls, i, j+1);
					}
			        }
			        catch(Exception e) {
			        }
				try {
					if(Balls[b][j].color == Balls[i][j].color &&
							Balls[b][j].checked == false &&
							Balls[b][j].empty == false) {
						Balls[b][j].checked = true;
						chain ++;
						collisionGrid(Balls, b, j);
					}
	                }
	                catch(Exception e) {
	                }
					try {
						if(Balls[b][j-1].color == Balls[i][j].color &&
								Balls[b][j-1].checked == false &&
								Balls[b][j-1].empty == false) {
							Balls[b][j-1].checked = true;
							chain ++;
							collisionGrid(Balls, b, j-1);
					}
				    }
				    catch(Exception e) {
				    }
		}
		else {
			
		try {
			if(Balls[a][j].color == Balls[i][j].color &&
					Balls[a][j].checked == false &&
					Balls[a][j].empty == false) {
				Balls[a][j].checked = true;
				chain ++;
				collisionGrid(Balls, a, j);
			}
			}
			catch(Exception e) {
			}
		try {
			if(Balls[a][j+1].color == Balls[i][j].color &&
					Balls[a][j+1].checked == false &&
					Balls[a][j+1].empty == false) {
				Balls[a][j+1].checked = true;
				chain ++;
				collisionGrid(Balls, a, j+1);
			}
		    }
		    catch(Exception e) {
		    }
		try {
			if(Balls[i][j-1].color == Balls[i][j].color &&
					Balls[i][j-1].checked == false &&
					Balls[i][j-1].empty == false) {
				Balls[i][j-1].checked = true;
				chain ++;
				collisionGrid(Balls, i, j-1);
			}
	        }
	        catch(Exception e) {
	        }
		try {
			if(Balls[i][j+1].color == Balls[i][j].color &&
					Balls[i][j+1].checked == false &&
					Balls[i][j+1].empty == false) {
				Balls[i][j+1].checked = true;
				chain ++;
				collisionGrid(Balls, i, j+1);
			}
	        }
	        catch(Exception e) {
	        }
		try {
			if(Balls[b][j].color == Balls[i][j].color &&
					Balls[b][j].checked == false &&
					Balls[b][j].empty == false) {
				Balls[b][j].checked = true;
				chain ++;
				collisionGrid(Balls, b, j);
			}
            }
            catch(Exception e) {
            }
			try {
				if(Balls[b][j+1].color == Balls[i][j].color &&
						Balls[b][j+1].checked == false &&
						Balls[b][j+1].empty == false) {
					Balls[b][j+1].checked = true;
					chain ++;
					collisionGrid(Balls, b, j+1);
			}
		    }
		    catch(Exception e) {
		    }
		}
	}
	
	public static void bubbleFall(GameGrid grid) {
		
		int y = 0;
		
		outerloop:
		for(int i = 0; i < grid.Balls.length; i++)
			for(int j = 0; j < grid.Balls[i].length; j++) {
				if(grid.Balls[i][j].y == 50) {
					y = i;
					break outerloop;
				}
			}
		for(int j = 0; j < grid.Balls[y].length; j++){
			if(grid.Balls[y][j].empty == false) {
				Attatched(grid.Balls, y, j, grid);
				grid.Balls[y][j].checked = true;
			}
		}
		
		for(int i = 0; i < grid.Balls.length; i++)
			for(int j = 0; j < grid.Balls[i].length; j++) {
				if(grid.Balls[i][j].checked == false && grid.Balls[i][j].empty == false) {
					grid.Balls[i][j].empty = true;
				}
				grid.Balls[i][j].checked = false;
			}
		
		
	}
	
	public static void Attatched(Ball[][] Balls, int i, int j, GameGrid grid) {
		
		int a = 0;
		int b = 0;
		
		for(int y = 0; y < grid.Balls.length; y++) {
			if(grid.Balls[i][1].y - 43 == grid.Balls[y][1].y){
				a = y;
			}
		}
		
		for(int y = 0; y < grid.Balls.length; y++) {
			if(grid.Balls[i][1].y + 43 == grid.Balls[y][1].y){
				b = y;
			}
		}
		
 
		if(Balls[i].length == 8) {
			try {
				if(Balls[a][j].checked == false &&
						Balls[a][j].empty == false) {
					Balls[a][j].checked = true;
					Attatched(Balls, a, j, grid);
					
				}
				}
				catch(Exception e) {
				}
			try {
				if(Balls[a][j-1].checked == false &&
						Balls[a][j-1].empty == false) {
					Balls[a][j-1].checked = true;
					Attatched(Balls, a, j-1, grid);
				}
			    }
			    catch(Exception e) {
			    }
			try {
				if(Balls[i][j-1].checked == false &&
						Balls[i][j-1].empty == false) {
					Balls[i][j-1].checked = true;
					Attatched(Balls, i, j-1, grid);
				}
		        }
		        catch(Exception e) {
		        }
			try {
				if(Balls[i][j+1].checked == false &&
						Balls[i][j+1].empty == false) {
					Balls[i][j+1].checked = true;
					Attatched(Balls, i, j+1, grid);
				}
		        }
		        catch(Exception e) {
		        }
			try {
				if(Balls[b][j].checked == false &&
						Balls[b][j].empty == false) {
					Balls[b][j].checked = true;
					Attatched(Balls, b, j, grid);
				}
                }
                catch(Exception e) {
                }
				try {
					if(Balls[b][j-1].checked == false &&
							Balls[b][j-1].empty == false) {
						Balls[b][j-1].checked = true;
						Attatched(Balls, b, j-1, grid);
				}
			    }
			    catch(Exception e) {
			    }
	}
	else {
		
	try {
		if(Balls[a][j].checked == false &&
				Balls[a][j].empty == false) {
			Balls[a][j].checked = true;
			Attatched(Balls, a, j, grid);
		}
		}
		catch(Exception e) {
		}
	try {
		if(Balls[a][j+1].checked == false &&
				Balls[a][j+1].empty == false) {
			Balls[a][j+1].checked = true;
			Attatched(Balls, a, j+1, grid);
		}
	    }
	    catch(Exception e) {
	    }
	try {
		if(Balls[i][j-1].checked == false &&
				Balls[i][j-1].empty == false) {
			Balls[i][j-1].checked = true;
			Attatched(Balls, i, j-1, grid);
		}
        }
        catch(Exception e) {
        }
	try {
		if(Balls[i][j+1].checked == false &&
				Balls[i][j+1].empty == false) {
			Balls[i][j+1].checked = true;
			Attatched(Balls, i, j+1, grid);
		}
        }
        catch(Exception e) {
        }
	try {
		if(Balls[b][j].checked == false &&
				Balls[b][j].empty == false) {
			Balls[b][j].checked = true;
			Attatched(Balls, b, j, grid);
		}
        }
        catch(Exception e) {
        }
		try {
			if(	Balls[b][j+1].checked == false &&
					Balls[b][j+1].empty == false) {
				Balls[b][j+1].checked = true;
				Attatched(Balls, b, j+1, grid);
		}
	    }
	    catch(Exception e) {
	    }
	}
	}
		

	}
