class CreateCliques < ActiveRecord::Migration[7.2]
  def change
    create_table :cliques do |t|
      t.references :network, null: false, foreign_key: true

      t.timestamps
    end
  end
end
