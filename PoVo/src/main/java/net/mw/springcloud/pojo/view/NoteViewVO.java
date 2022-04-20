package net.mw.springcloud.pojo.view;

import lombok.Data;
import net.mw.springcloud.pojo.vo.NoteVO;

@Data
public class NoteViewVO extends NoteVO {
    private String user;
}
