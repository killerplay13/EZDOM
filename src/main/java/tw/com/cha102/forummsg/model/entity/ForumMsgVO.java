package tw.com.cha102.forummsg.model.entity;


import lombok.*;
import tw.com.cha102.core.vo.Core;
import tw.com.cha102.forum.model.entity.ForumPostVO;
import tw.com.cha102.member.model.entity.Member;


import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(name = "FORUMMSG",catalog ="cha102g4_test")
public class ForumMsgVO extends Core {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FORUMMSG_ID")
    private Integer forumMsgId;

    @Column(name = "FORUMPOST_ID")
    private Integer forumPostId;

    @Column(name = "MEMBER_ID")
    private Integer memberId;

    @Column(name = "FORUMMSG_CONTENT")
    private String forumMsgContent;

    @Column(name = "FORUMMSG_TIME",insertable = false)
    private Timestamp forumMsgTime;

    @ManyToOne
    @JoinColumn(name = "FORUMPOST_ID", insertable = false, updatable = false)
    private ForumPostVO forumPost;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private Member member;

    // 新增一個屬性以包含 memberName
    @Transient // 使用 @Transient 標註，以防止該屬性映射到數據庫表格
    private String memberName;;
}

