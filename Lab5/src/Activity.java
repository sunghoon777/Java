public enum Activity {
	LITTLE_TO_NO_EXERCISE, 
	LIGHT_EXERCISE, // 1~3 days per week
	MODERATE_EXERCISE, // 3~5 days per week
	HEAVY_EXERCISE, // 6-7 days per week
	VERY_HEAVY_EXERCISE; // twice per day, extra heavy workouts

	public static String[] names() {
		String[] names = new String[Activity.values().length];
		for (Activity t : Activity.values()) 
			names[t.ordinal()] = t.toString();
		return names;
	}
}