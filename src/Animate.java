
public class Animate implements Runnable{
	public Animate(BlockPannel bp) {
		this.blockBreaker = bp;
	}
	BlockPannel blockBreaker;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			blockBreaker.update();
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
