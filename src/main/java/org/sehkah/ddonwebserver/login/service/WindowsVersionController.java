package org.sehkah.ddonwebserver.login.service;

import lombok.extern.slf4j.Slf4j;
import org.sehkah.ddonwebserver.login.domain.dao.VersionRepository;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/patch/master/win")
@Slf4j
public class WindowsVersionController {
    private final VersionRepository repository;

    public WindowsVersionController(VersionRepository repository) {
        this.repository = repository;
    }

    /**
     * Original sample request:
     * <code>
     * GET /patch/master/win/versionlist HTTP/1.1
     * Connection: Keep-Alive
     * User-Agent: Capcom Web Client/2.0 (generic)
     * Host: dl.dd-on.jp
     * </code>
     * Original sample response:
     * <code>
     * HTTP/1.1 200 OK
     * Server: nginx
     * Content-Type: application/octet-stream
     * Last-Modified: Fri, 25 Jan 2019 02:16:11 GMT
     * ETag: "5c4a716b-c8"
     * Accept-Ranges: bytes
     * Content-Length: 200
     * Date: Sat, 06 Jul 2019 18:04:11 GMT
     * Connection: keep-alive
     * </code>
     */
    @GetMapping(
            value = "/versionlist",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ByteArrayResource getWindowsClientVersionList() {
        return new ByteArrayResource(repository.getWindowsVersionList().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Original sample request:
     * <code>
     * GET /patch/master/win/exe_version HTTP/1.1
     * Connection: Keep-Alive
     * User-Agent: Capcom Web Client/2.0 (generic)
     * Host: dl.dd-on.jp
     * </code>
     * <p>
     * Original sample response:
     * <code>
     * HTTP/1.1 200 OK
     * Server: nginx
     * Content-Type: application/octet-stream
     * Last-Modified: Wed, 27 Feb 2019 06:49:13 GMT
     * ETag: "5c7632e9-5d1"
     * Accept-Ranges: bytes
     * Content-Length: 1489
     * Date: Sat, 06 Jul 2019 18:04:11 GMT
     * Connection: keep-alive
     * </code>
     */
    @GetMapping(
            value = "/exe_version",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ByteArrayResource  getWindowsClientExeVersion() {
        return new ByteArrayResource(repository.getWindowsExeVersion().getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Original sample request:
     * <code>
     * GET /patch/master/win/03040008/fulllist HTTP/1.1
     * Connection: Keep-Alive
     * User-Agent: Capcom Web Client/2.0 (generic)
     * Host: dl.dd-on.jp
     * </code>
     * <p>
     * Original sample response:
     * <code>
     * HTTP/1.1 200 OK
     * Server: nginx
     * Content-Type: application/octet-stream
     * Last-Modified: Wed, 27 Feb 2019 06:21:52 GMT
     * ETag: "5c762c80-836b2d"
     * Accept-Ranges: bytes
     * Content-Length: 8612653
     * Date: Sat, 06 Jul 2019 18:04:12 GMT
     * Connection: keep-alive
     * </code>
     */
    @GetMapping(
            value = "/{version}/fulllist",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public ByteArrayResource getClientFullListForVersion(@PathVariable String version) {
        return new ByteArrayResource(repository.getWindowsFullList(version).getBytes(StandardCharsets.UTF_8));
    }
}
