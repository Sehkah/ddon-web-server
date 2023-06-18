package org.sehkah.ddonwebserver.login.domain.dao;

import org.sehkah.ddonwebserver.login.domain.entity.ExeVersion;
import org.sehkah.ddonwebserver.login.domain.entity.FullList;
import org.sehkah.ddonwebserver.login.domain.entity.VersionList;
import org.springframework.stereotype.Component;

@Component
public class VersionRepository {
    public String getWindowsExeVersion() {
        return ExeVersion.SEASON_3_LATEST_WINDOWS;
    }

    public String getWindowsFullList(String version) {
        if (version.startsWith("03")) {
            return FullList.SEASON_3_LATEST_WINDOWS;
        } else {
            throw new RuntimeException("Unsupported version: " + version);
        }
    }

    public String getWindowsVersionList() {
        return VersionList.SEASON_3_LATEST_WINDOWS;
    }
}
