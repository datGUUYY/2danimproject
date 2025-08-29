package Default;

import java.util.HashSet;

public abstract class Updator {
	protected static HashSet<Updator> updators = new HashSet<>();
	public Updator()
	{
		updators.add(this);
	}
	
	protected abstract void update();
	
	public static void updateAll()
	{
		for(Updator updator : updators)
		{
			updator.update();
		}
	}
}
