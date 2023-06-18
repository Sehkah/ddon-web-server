package org.sehkah.ddonwebserver.login.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class VersionList {
    public static final String SEASON_3_LATEST_WINDOWS;

    static {
        try {
            SEASON_3_LATEST_WINDOWS = Files.readString(Paths.get(Objects.requireNonNull(ExeVersion.class.getClassLoader().getResource("win/versionlist")).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private int headerVersion = 2;
    private List<String> normalVersions;

    @Override
    public String toString() {
        return "version:" + headerVersion + '\n' + String.join("\n", normalVersions);
    }
}
