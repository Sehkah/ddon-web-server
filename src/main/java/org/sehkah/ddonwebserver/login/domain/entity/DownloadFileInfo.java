package org.sehkah.ddonwebserver.login.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DownloadFileInfo {
    private String name;
    private long size;
    private String binaryHash;
    private String splitFile;
    private long attribute;

    @Override
    public String toString() {
        return name + ',' + size + ',' + binaryHash + ',' + splitFile + ',' + attribute;
    }
}
