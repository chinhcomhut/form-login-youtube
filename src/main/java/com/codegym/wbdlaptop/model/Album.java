package com.codegym.wbdlaptop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameAlbum;
    private String avatarAlbum;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles" ,
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Playlist> playlists;
    @ManyToOne
    User user;

    public Album() {
    }

    public Album(Long id, String nameAlbum, String avatarAlbum, List<Playlist> playlists, User user) {
        this.id = id;
        this.nameAlbum = nameAlbum;
        this.avatarAlbum = avatarAlbum;
        this.playlists = playlists;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public String getAvatarAlbum() {
        return avatarAlbum;
    }

    public void setAvatarAlbum(String avatarAlbum) {
        this.avatarAlbum = avatarAlbum;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
