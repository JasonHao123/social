package jason.app.socialcapital.socialcommon.service;

import jason.app.socialcapital.socialcommon.domain.World;

import java.util.Collection;

public interface GalaxyService {

	
	public long getNumberOfWorlds();
	
	public World createWorld(String name, int moons) ;
	
	public Iterable<World> getAllWorlds();
	
	public World findWorldById(Long id) ;


    // This is using the legacy index
	public Iterable<World> findAllByNumberOfMoons(int numberOfMoons);
	
	public Collection<World> makeSomeWorlds();
	
}
