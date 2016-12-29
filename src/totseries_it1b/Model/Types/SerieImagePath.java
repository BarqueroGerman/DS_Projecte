/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totseries_it1b.Model.Types;

/**
 *
 * @author Enric Calvo & German Barquero
 */
public class SerieImagePath {

    private static class BREAKING_BAD {

        public final static String Key = "bbad";
        public final static String ImagePath = "";
    }

    private static class MRROBOT {

        public final static String Key = "mrobot";
        public final static String ImagePath = "";
    }

    private static class GAME_OF_THRONES {

        public final static String Key = "gofthrones";
        public final static String ImagePath = "/images/series/got.png";
    }

    private static class PENNY_DREADFUL {

        public final static String Key = "pdreadful";
        public final static String ImagePath = "";
    }

    private static class BLACK_MIRROR {

        public final static String Key = "bmirror";
        public final static String ImagePath = "";
    }

    private static class SONS_OF_ANARCHY {

        public final static String Key = "sofanarchy";
        public final static String ImagePath = "";
    }

    private static class STRANGER_THINGS {

        public final static String Key = "sthings";
        public final static String ImagePath = "";
    }

    private static class MISFITS {

        public final static String Key = "misfits";
        public final static String ImagePath = "";
    }

    private static class PEAKY_BLINDERS {

        public final static String Key = "pblinders";
        public final static String ImagePath = "";
    }

    private static class THE_WALKING_DEAD {

        public final static String Key = "wdead";
        public final static String ImagePath = "";
    }

    public static String getImagePath(String key) {
        switch (key) {
            case BREAKING_BAD.Key:
                return BREAKING_BAD.ImagePath;
            case MRROBOT.Key:
                return MRROBOT.ImagePath;
            case GAME_OF_THRONES.Key:
                return GAME_OF_THRONES.ImagePath;
            case PENNY_DREADFUL.Key:
                return PENNY_DREADFUL.ImagePath;
            case BLACK_MIRROR.Key:
                return BLACK_MIRROR.ImagePath;
            case SONS_OF_ANARCHY.Key:
                return SONS_OF_ANARCHY.ImagePath;
            case STRANGER_THINGS.Key:
                return STRANGER_THINGS.ImagePath;
            case MISFITS.Key:
                return MISFITS.ImagePath;
            case PEAKY_BLINDERS.Key:
                return PEAKY_BLINDERS.ImagePath;
            case THE_WALKING_DEAD.Key:
                return THE_WALKING_DEAD.ImagePath;
            default:
                return null;
        }
    }

}
