package org.sehkah.ddonwebserver.login.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
public class ExeVersion {
    public static final String SEASON_3_LATEST_WINDOWS;

    static {
        try {
            SEASON_3_LATEST_WINDOWS = Files.readString(Paths.get(Objects.requireNonNull(ExeVersion.class.getClassLoader().getResource("win/exe_version")).toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private List<ExeFileInfo> exeFileInfo;

    @Override
    public String toString() {
        return exeFileInfo.stream().map(ExeFileInfo::toString).collect(Collectors.joining("\n"));
    }
}
