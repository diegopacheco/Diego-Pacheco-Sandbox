atom_feed do |feed|
	feed.title "My Rails 3 Blog"
	feed.updated @posts.last.updated_at
	
	@posts.each do |post|
		feed.entry(post) do |entry|
			
			entry.title   post.tittle			
			entry.sumary  post.body
			entry.content post.body, :type => "html"
			
			entry.author do |author|
				author.name "Diego Pacheco"
			end
		end
	end	
end