package as_801;

public class Video extends Multimedia {
	
	public Video() {
		
	}
		
	public Video(String name, Double duration) {
		super(name,duration);
	}
	
	public void createVideo() {
		super.createMultimedia();
	}

	@Override
	public String toString() {
		return "Video [Name=" + getName() + ", Duration=" + getDuration() + "]";
	}

}
