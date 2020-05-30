package com.example.a3_1_servicios;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class Pelicula implements Parcelable {
        //479b8c1486102d3a94b544e525cda371 api key
        // https://api.themoviedb.org/3/movie/550?api_key=479b8c1486102d3a94b544e525cda371
        double popularity;
        int voteCount;
        boolean video;
        String posterPath;
        int id;
        boolean adult;
        String backdropPath;
        String originalLanguage;
        String originalTitle;
        List<Integer> genreIds;
        String title;
        double voteAverage;
        String overview;
        String releaseDate;

    public Pelicula(double popularity, String originalLanguage, String originalTitle, String title, double voteAverage, String overview, String posterPath) {
        this.popularity = popularity;
        this.originalLanguage = originalLanguage;
        this.originalTitle = originalTitle;
        this.title = title;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public Pelicula(double popularity, int voteCount, boolean video, String posterPath, int id, boolean adult, String backdropPath, String originalLanguage, String originalTitle, List<Integer> genreIds, String title, double voteAverage, String overview, String releaseDate) {
            this.popularity = popularity;
            this.voteCount = voteCount;
            this.video = video;
            this.posterPath = posterPath;
            this.id = id;
            this.adult = adult;
            this.backdropPath = backdropPath;
            this.originalLanguage = originalLanguage;
            this.originalTitle = originalTitle;
            this.genreIds = genreIds;
            this.title = title;
            this.voteAverage = voteAverage;
            this.overview = overview;
            this.releaseDate = releaseDate;
        }

        protected Pelicula(Parcel in) {
            popularity = in.readDouble();
            voteCount = in.readInt();
            video = in.readByte() != 0;
            posterPath = in.readString();
            id = in.readInt();
            adult = in.readByte() != 0;
            backdropPath = in.readString();
            originalLanguage = in.readString();
            originalTitle = in.readString();
            title = in.readString();
            voteAverage = in.readDouble();
            overview = in.readString();
            releaseDate = in.readString();
        }

        public static final Creator<Pelicula> CREATOR = new Creator<Pelicula>() {
            @Override
            public Pelicula createFromParcel(Parcel in) {
                return new Pelicula(in);
            }

            @Override
            public Pelicula[] newArray(int size) {
                return new Pelicula[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeDouble(popularity);
            dest.writeInt(voteCount);
            dest.writeByte((byte) (video ? 1 : 0));
            dest.writeString(posterPath);
            dest.writeInt(id);
            dest.writeByte((byte) (adult ? 1 : 0));
            dest.writeString(backdropPath);
            dest.writeString(originalLanguage);
            dest.writeString(originalTitle);
            dest.writeString(title);
            dest.writeDouble(voteAverage);
            dest.writeString(overview);
            dest.writeString(releaseDate);
        }

        public double getPopularity() {
            return popularity;
        }

        public void setPopularity(double popularity) {
            this.popularity = popularity;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }

        public boolean isVideo() {
            return video;
        }

        public void setVideo(boolean video) {
            this.video = video;
        }

        public String getPosterPath() {
            return posterPath;
        }

        public void setPosterPath(String posterPath) {
            this.posterPath = posterPath;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isAdult() {
            return adult;
        }

        public void setAdult(boolean adult) {
            this.adult = adult;
        }

        public String getBackdropPath() {
            return backdropPath;
        }

        public void setBackdropPath(String backdropPath) {
            this.backdropPath = backdropPath;
        }

        public String getOriginalLanguage() {
            return originalLanguage;
        }

        public void setOriginalLanguage(String originalLanguage) {
            this.originalLanguage = originalLanguage;
        }

        public String getOriginalTitle() {
            return originalTitle;
        }

        public void setOriginalTitle(String originalTitle) {
            this.originalTitle = originalTitle;
        }

        public List<Integer> getGenreIds() {
            return genreIds;
        }

        public void setGenreIds(List<Integer> genreIds) {
            this.genreIds = genreIds;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getVoteAverage() {
            return voteAverage;
        }

        public void setVoteAverage(double voteAverage) {
            this.voteAverage = voteAverage;
        }

        public String getOverview() {
            return overview;
        }

        public void setOverview(String overview) {
            this.overview = overview;
        }

        public String getReleaseDate() {
            return releaseDate;
        }

        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }
    }

