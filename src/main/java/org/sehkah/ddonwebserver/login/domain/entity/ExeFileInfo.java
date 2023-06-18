package org.sehkah.ddonwebserver.login.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ExeFileInfo {
    private String version;
    private String path;
    private long size;
    private String binaryHash;
    private long attribute;

    @Override
    public String toString() {
        return version + ',' + path + ',' + size + ',' + binaryHash + ',' + attribute;
    }
}
