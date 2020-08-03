/*
 * Copyright 2015-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.rsocket.exceptions;

import io.rsocket.RSocketErrorException;
import io.rsocket.frame.ErrorFrameCodec;
import reactor.util.annotation.Nullable;

/**
 * The connection is being terminated. Sender or Receiver of this frame MUST wait for outstanding
 * streams to terminate before closing the connection. New requests MAY not be accepted.
 *
 * @see <a href="https://github.com/rsocket/rsocket/blob/master/Protocol.md#error-codes">Error
 *     Codes</a>
 */
public final class ConnectionCloseException extends RSocketErrorException {

  private static final long serialVersionUID = -2214953527482377471L;

  /**
   * Constructs a new exception with the specified message.
   *
   * @param message the message
   */
  public ConnectionCloseException(String message) {
    this(message, null);
  }

  /**
   * Constructs a new exception with the specified message and cause.
   *
   * @param message the message
   * @param cause the cause of this exception
   */
  public ConnectionCloseException(String message, @Nullable Throwable cause) {
    super(ErrorFrameCodec.CONNECTION_CLOSE, message, cause);
  }
}
