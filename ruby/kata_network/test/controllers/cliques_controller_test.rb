require "test_helper"

class CliquesControllerTest < ActionDispatch::IntegrationTest
  setup do
    @clique = cliques(:one)
  end

  test "should get index" do
    get cliques_url, as: :json
    assert_response :success
  end

  test "should create clique" do
    assert_difference("Clique.count") do
      post cliques_url, params: { clique: { network_id: @clique.network_id } }, as: :json
    end

    assert_response :created
  end

  test "should show clique" do
    get clique_url(@clique), as: :json
    assert_response :success
  end

  test "should update clique" do
    patch clique_url(@clique), params: { clique: { network_id: @clique.network_id } }, as: :json
    assert_response :success
  end

  test "should destroy clique" do
    assert_difference("Clique.count", -1) do
      delete clique_url(@clique), as: :json
    end

    assert_response :no_content
  end
end
