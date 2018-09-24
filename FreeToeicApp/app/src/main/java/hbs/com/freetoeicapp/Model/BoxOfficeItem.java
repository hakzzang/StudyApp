package hbs.com.freetoeicapp.Model;

import com.google.gson.annotations.SerializedName;

public class BoxOfficeItem {
    @SerializedName("boxOfficeResult")
    BoxOfficeResult boxOfficeResult;

    public BoxOfficeItem(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

    public BoxOfficeResult getBoxOfficeResult() {
        return boxOfficeResult;
    }

    public void setBoxOfficeResult(BoxOfficeResult boxOfficeResult) {
        this.boxOfficeResult = boxOfficeResult;
    }

    private class BoxOfficeResult {
        @SerializedName("boxofficeType")
        String boxOfficeType;

        @SerializedName("showRange")
        String showRange;

        @SerializedName("dailyBoxOfficeList")
        DailyBoxOffice[] dailyBoxOfficeList;

        public DailyBoxOffice[] getDailyBoxOfficeList() {
            return dailyBoxOfficeList;
        }

        public void setDailyBoxOfficeList(DailyBoxOffice[] dailyBoxOfficeList) {
            this.dailyBoxOfficeList = dailyBoxOfficeList;
        }

        public BoxOfficeResult(String boxOfficeType, String showRange, DailyBoxOffice[] dailyBoxOfficeList) {
            this.boxOfficeType = boxOfficeType;
            this.showRange = showRange;
            this.dailyBoxOfficeList = dailyBoxOfficeList;
        }
    }

    private class DailyBoxOffice {
        @SerializedName("rank")
        String rank;

        @SerializedName("rankOldAndNew")
        String rankOldAndNew;

        @SerializedName("movieNm")
        String movieNm;

        @SerializedName("openDt")
        String openDt;

        @SerializedName("audiChange")
        String audiChange;

        @SerializedName("audiAcc")
        String audiAcc;

        @SerializedName("movieCd")
        String movieCd;

        public DailyBoxOffice(String rank, String rankOldAndNew, String movieNm, String openDt, String audiChange, String audiAcc, String movieCd) {
            this.rank = rank;
            this.rankOldAndNew = rankOldAndNew;
            this.movieNm = movieNm;
            this.openDt = openDt;
            this.audiChange = audiChange;
            this.audiAcc = audiAcc;
            this.movieCd = movieCd;
        }

        public String getMovieCd() {
            return movieCd;
        }

        public String getRank() {
            return rank;
        }

        public String getRankOldAndNew() {
            return rankOldAndNew;
        }

        public String getMovieNm() {
            return movieNm;
        }

        public String getOpenDt() {
            return openDt;
        }

        public String getAudiChange() {
            return audiChange;
        }

        public String getAudiAcc() {
            return audiAcc;
        }
    }
}
