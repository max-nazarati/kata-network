class NetworksController < ApplicationController
  before_action :set_network, only: %i[ show destroy ]

  # GET /networks
  def index
    @networks = Network.all

    render json: @networks
  end

  # GET /networks/1
  def show
    render json: @network
  end

  # POST /networks
  def create
    @network = Network.new(network_params)

    if @network.save
      render json: @network, status: :created, location: @network
    else
      render json: @network.errors, status: :unprocessable_entity
    end
  end
  
  # DELETE /networks/1
  def destroy
    @network.destroy!
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_network
      @network = Network.find(params[:id])
    end

    # Only allow a list of trusted parameters through.
    def network_params
      params.fetch(:network, {})
    end
end
