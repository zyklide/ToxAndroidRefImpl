package com.zoffcc.applications.trifa;

import android.support.annotation.Nullable;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

@Table
public class Message
{
    @PrimaryKey(autoincrement = true, auto = true)
    long id;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    long message_id = -1;

    // @Column(indexed = true, helpers = Column.Helpers.ALL)
    // long tox_friendnum;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    String tox_friendpubkey;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    int direction = 0; // 0 -> msg received, 1 -> msg sent

    @Column(indexed = true)
    int TOX_MESSAGE_TYPE = 0; // 0 -> normal, 1 -> action

    @Column(helpers = Column.Helpers.ALL)
    @Nullable
    long sent_timestamp = 0L;

    @Column(indexed = true)
    @Nullable
    long rcvd_timestamp = 0L;

    @Column(helpers = Column.Helpers.ALL)
    boolean read = false;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    boolean is_new = true;

    @Column(helpers = Column.Helpers.ALL)
    @Nullable
    String text = null;

    @Column(helpers = Column.Helpers.ALL)
    @Nullable
    String filename_fullpath = null;

    static Message deep_copy(Message in)
    {
        Message out = new Message();
        out.id = in.id;
        // out.tox_friendnum = in.tox_friendnum;
        out.direction = in.direction;
        out.TOX_MESSAGE_TYPE = in.TOX_MESSAGE_TYPE;
        out.sent_timestamp = in.sent_timestamp;
        out.rcvd_timestamp = in.rcvd_timestamp;
        out.read = in.read;
        out.text = in.text;
        out.tox_friendpubkey = in.tox_friendpubkey;
        out.filename_fullpath = in.filename_fullpath;
        out.message_id = in.message_id;
        out.is_new = in.is_new;

        return out;
    }

    @Override
    public String toString()
    {
        return "id=" + id + ", message_id=" + message_id + ", tox_friendpubkey=" + tox_friendpubkey + ", direction=" + direction + ", TOX_MESSAGE_TYPE=" + TOX_MESSAGE_TYPE + ", sent_timestamp=" + sent_timestamp + ", rcvd_timestamp=" + rcvd_timestamp + ", read=" + read + ", text=" + text + ", filename_fullpath=" + filename_fullpath + ", is_new=" + is_new;
    }
}
