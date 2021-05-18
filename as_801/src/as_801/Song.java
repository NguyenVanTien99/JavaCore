package as_801;

public class Song extends Multimedia {
	private String single;
	
	public Song() {
		
	}
	
	public Song(String name, Double duration, String single) {
		super(name, duration);
		this.single = single;
	}
	

	public String getSingle() {
		return single;
	}

	public void setSingle(String single) {
		this.single = single;
	}

	
	public void createSong() {
		super.createMultimedia();
		
		System.out.print("Enter the single: ");
		single = scanner.nextLine();	
		
	}

	@Override
	public String toString() {
		return "Song [single=" + single + ", Name=" + getName() + ", Duration=" + getDuration() + "]";
	}




	
	
}
