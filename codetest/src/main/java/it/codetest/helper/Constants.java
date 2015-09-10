package it.codetest.helper;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generic constants
 * @author Flavio
 *
 */
public class Constants {
	
	public static final String LOVE = "love";
	public static final String FIFTEEN = "fifteen";
	public static final String THIRTY = "thirty";
	public static final String FOURTY = "fourty";
	
	public static final String SPACE = " ";
	public static final String ADVANTAGE = "Advantage";
	public static final String DEUCE = "Deuce";
	public static final String GAME = "Game";
	
	/**
	 * Mapping between progressive points and tennis points
	 */
	public static final Map<Integer, String> POINTS_MAP;
    static {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, Constants.LOVE);
        map.put(1, Constants.FIFTEEN);
        map.put(2, Constants.THIRTY);
        map.put(3, Constants.FOURTY);
        POINTS_MAP = Collections.unmodifiableMap(map);
    }
	
}
