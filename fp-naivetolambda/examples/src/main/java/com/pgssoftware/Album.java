/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pgssoftware;

import java.util.List;

/**
 *
 * @author kuba
 */
public class Album {

    public String name;
    public String musician;
    public int year;
    
    public List<Track> tracks;
    public List<String> performers;

//    public List<String> getPerformers() {
//        return performers;
//    }

    @Override
    public String toString() {
        return String.format("%s - %s (%d)", musician, name, year );
    }

    public static class Builder {

        private String name;
        private String musician;
        private int year;
        private List<Track> tracks;
        private List<String> performers;

        private Builder() {
        }

        public Builder name(final String value) {
            this.name = value;
            return this;
        }

        public Builder musician(final String value) {
            this.musician = value;
            return this;
        }

        public Builder year(final int value) {
            this.year = value;
            return this;
        }

        public Builder tracks(final List<Track> value) {
            this.tracks = value;
            return this;
        }

        public Builder performers(final List<String> value) {
            this.performers = value;
            return this;
        }

        public Album build() {
            return new com.pgssoftware.Album(name, musician, year, tracks, performers);
        }
    }

    public static Album.Builder builder() {
        return new Album.Builder();
    }

    private Album(final String name, final String musician, final int year, final List<Track> tracks, final List<String> performers) {
        this.name = name;
        this.musician = musician;
        this.year = year;
        this.tracks = tracks;
        this.performers = performers;
    }
    
    

}

