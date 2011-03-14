class AddPublishedToPost < ActiveRecord::Migration
  def self.up
    add_column :posts, :published_on, :date
  end

  def self.down
    remove_column :posts, :published_on
  end
end
