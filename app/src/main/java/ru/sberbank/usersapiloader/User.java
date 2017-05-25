package ru.sberbank.usersapiloader;

/**
 * Created by user8 on 23.05.2017.
 */

public class User {
    private String login;
    private Long id;
    private String url;
    private String html_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String login, Long id, String url, String html_url) {
        this.login = login;
        this.id = id;
        this.url = url;
        this.html_url = html_url;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (url != null ? !url.equals(user.url) : user.url != null) return false;
        return html_url != null ? html_url.equals(user.html_url) : user.html_url == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + id.hashCode();
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (html_url != null ? html_url.hashCode() : 0);
        return result;
    }
}
