package sn.timeline.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import sn.timeline.Post;
import sn.timeline.Timeline;

public class SimpleTimeline
	implements Timeline
{
	private List<Post> posts = new ArrayList<>();

	private long	userId;

	public SimpleTimeline(long userId)
	{
		this.userId = userId;
	}

	@Override
	public int size()
	{
		return posts.size();
	}

	@Override
	public void add(Post post)
	{
		String tag = DateFormatUtils.format(post.getDate(), "yyyyMMdd-hhmmss");
		String id = tag + "_" + RandomStringUtils.randomAlphanumeric(8);
		post.setPostId(id);
		posts.add(post);
	}

	@Override
	public List<Post> getAll()
	{
		return Collections.unmodifiableList(posts);
	}
}