package com.cduestc.keep.model;

public class Friend {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_friend.friend_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long friendId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_friend.friend_friendID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long friendFriendid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column keep_friend.friend_userID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    private Long friendUserid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_friend.friend_ID
     *
     * @return the value of keep_friend.friend_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getFriendId() {
        return friendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_friend.friend_ID
     *
     * @param friendId the value for keep_friend.friend_ID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_friend.friend_friendID
     *
     * @return the value of keep_friend.friend_friendID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getFriendFriendid() {
        return friendFriendid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_friend.friend_friendID
     *
     * @param friendFriendid the value for keep_friend.friend_friendID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setFriendFriendid(Long friendFriendid) {
        this.friendFriendid = friendFriendid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column keep_friend.friend_userID
     *
     * @return the value of keep_friend.friend_userID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public Long getFriendUserid() {
        return friendUserid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column keep_friend.friend_userID
     *
     * @param friendUserid the value for keep_friend.friend_userID
     *
     * @mbg.generated Mon Apr 13 21:51:09 CST 2020
     */
    public void setFriendUserid(Long friendUserid) {
        this.friendUserid = friendUserid;
    }
}