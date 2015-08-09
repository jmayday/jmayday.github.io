List<Artist> musicians = album.getMusicians()
.collect(toList());

List<Artist> bands = musicians.stream()
.filter(artist -> artist.getName().startsWith("The"))
.collect(toList());

Set<String> origins = bands.stream()
.map(artist -> artist.getNationality())
.collect(toSet());


public Set<String> findLongTracks(List<Album> albums) {
	Set<String> trackNames = new HashSet<>();
	for(Album album : albums) {
		for (Track track : album.getTrackList()) {
			if (track.getLength() > 60) {
				String name = track.getName();
				trackNames.add(name);
			}
		}
	}
	return trackNames;
}

public Set<String> findLongTracks(List<Album> albums) {
	Set<String> trackNames = new HashSet<>();
	albums.stream()
	.forEach(album -> {
		album.getTracks()
		.forEach(track -> {
			if (track.getLength() > 60) {
				String name = track.getName();
				trackNames.add(name);
			}
		});
	});
	return trackNames;
}

IntStream.iterate(0, i -> i + 1)
         .limit(10) // LIMIT
         .skip(5)   // OFFSET
         .forEach(System.out::println);